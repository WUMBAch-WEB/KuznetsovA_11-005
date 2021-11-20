package ru.itis.spring.util;

public interface EmailUtil {
    void sendMail(String to, String subject, String from, String text);
}
