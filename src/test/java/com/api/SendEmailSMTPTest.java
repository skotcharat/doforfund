package com.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


/**
 * The type Send email smtp test.
 */
class SendEmailSMTPTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets response success.
     */
    @Test
    void sendEmailSuccess() {
        SendEmailSMTP send = new SendEmailSMTP();
        send.getInfo("testing class", "send email successfully");
    }
}