package edu.matc.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
@Log4j
public class SendEmailSMTP {

    public void getInfo(String Subject, String message) {

        final String fromEmail = "yingritta@gmail.com"; //requires valid gmail id
        final String password = "0866053103"; // correct password for gmail id
        final String toEmail = "yingritta@gmail.com"; // can be any email id

        //log.error("SSLEmail Start");
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
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        //log.error("Session created");
        EmailUtil.sendEmail(session, toEmail,Subject, message);

    }

}