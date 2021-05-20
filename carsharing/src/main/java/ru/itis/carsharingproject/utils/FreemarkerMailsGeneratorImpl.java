package ru.itis.carsharingproject.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class FreemarkerMailsGeneratorImpl implements MailsGenerator {

    @Autowired
    private Configuration configuration;

    @Override
    public String getMailForConfirm(String serverUrl, String code) {
        Template confirmMailTemplate;
        try {
            confirmMailTemplate = configuration.getTemplate("mails/confirm_mail.ftlh");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        Map<String, String> attributes = new HashMap<>();
        attributes.put("confirm_code", code);
        attributes.put("server_url", serverUrl);

        StringWriter writer = new StringWriter();
        try {
            confirmMailTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalArgumentException(e);
        }
        return writer.toString();
    }

    @Override
    public String getMailForContact(String firstname, String email, String subject, String description) {
        Template confirmMailTemplate;
        try {
            confirmMailTemplate = configuration.getTemplate("mails/contact_mail.ftlh");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        Map<String, String> attributes = new HashMap<>();
        attributes.put("message_firstname", firstname);
        attributes.put("message_email", email);
        attributes.put("message_subject", subject);
        attributes.put("message_description", description);

        StringWriter writer = new StringWriter();
        try {
            confirmMailTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalArgumentException(e);
        }
        return writer.toString();
    }
}