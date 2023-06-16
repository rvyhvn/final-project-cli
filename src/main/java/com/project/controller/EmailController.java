package com.project.controller;

import com.project.model.Email;
import com.project.util.EmailUtil;

import java.util.List;

public class EmailController {

    public void sendEmailToRecipients(List<String> recipients, String subject, String body, String attachmentPath) {
        // Membuat objek Email dengan parameter yang diberikan
        Email email = new Email(subject, body, recipients, attachmentPath);

        // Mengirim email menggunakan EmailUtil
        EmailUtil.sendEmail(email);
    }
}
