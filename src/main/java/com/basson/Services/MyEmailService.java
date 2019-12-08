package com.basson.Services;


import javax.mail.internet.AddressException;

public interface MyEmailService {

    public void sendEmail(String msg) throws AddressException;

}
