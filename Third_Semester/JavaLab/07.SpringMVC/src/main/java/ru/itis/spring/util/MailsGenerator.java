package ru.itis.spring.util;

public interface MailsGenerator {

    String getMailForConfirm(String serverUrl, String code);
}
