package com.api;

import com.api.EmailUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.io.IOException;
import java.util.Properties;

public class SendEmailSMTP {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;

    // private constructor prevents instantiating this class anywhere else
    public SendEmailSMTP() {
        loadProperties();
    }

    // load properties
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/email.properties"));
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file.." + ioe);
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
        }

    }

    public void getInfo(String Subject, String message) {
        logger.error("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty("fromEmail"), properties.getProperty("password"));
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        logger.error("Session created");
        EmailUtil.sendEmail(session, properties.getProperty("toEmail"),Subject, message);

    }

}