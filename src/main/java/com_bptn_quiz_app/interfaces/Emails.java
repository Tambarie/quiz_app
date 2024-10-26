package com_bptn_quiz_app.interfaces;

import org.apache.commons.mail.EmailException;

public interface Emails {
    String SendEmail( String userEmail, String message) throws EmailException;
}
