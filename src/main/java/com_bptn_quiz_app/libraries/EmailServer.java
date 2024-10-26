package com_bptn_quiz_app.libraries;

import com_bptn_quiz_app.constants.Const;
import com_bptn_quiz_app.interfaces.Emails;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;

public class EmailServer implements Emails {

    @Override
    public String SendEmail(String userEmail, String message) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(Const.USERNAME, Const.PASSWORD));
        email.setSSLOnConnect(true);
        email.setFrom("gt.gbaragbo@gmail.com");
        email.setSubject("Welcome to TD Quiz App");
        email.setMsg(message);
        email.addTo(userEmail);
        email.send();
        return "Email sent";
    }
}
