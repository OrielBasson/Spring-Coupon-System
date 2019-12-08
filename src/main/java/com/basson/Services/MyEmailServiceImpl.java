package com.basson.Services;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.nio.charset.Charset;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyEmailServiceImpl implements MyEmailService {


    @Autowired
    public EmailService emailService;


    @Override
    public void sendEmail(String msg) throws AddressException {
        final Email email = DefaultEmail.builder()
                .from(new InternetAddress("orielbassonlandingpage@gmail.com"))
                .replyTo(new InternetAddress("orielbassonlandingpage@gmail.com"))
                .to(Lists.newArrayList(new InternetAddress("orielbassonlandingpage@gmail.com")))
                .subject("Email Contact From Landing Page")
                .body(msg)
                .encoding(String.valueOf(Charset.forName("UTF-8"))).build();
        emailService.send(email);
    }


}
