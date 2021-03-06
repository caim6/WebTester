package caim.study.jee.services.impl;

import caim.study.jee.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;



@Service("emailService")
public class EmailServiceStub implements EmailService {

    @Autowired
    private JavaMailSender defaultMailSender;

    @Autowired
    private Settings emailSettings;


    @Override
    public void sendVerificationEmail(String destinationEmail, String name, String content) throws javax.mail.MessagingException {
        sendEmail(destinationEmail, name, emailSettings.getVerificationEmailFileName(), emailSettings.getFromName(), emailSettings.getSubject(), content);
    }

    public void sendEmail(String destinationEmail, String name, String fromEmail, String fromName,
                          String subject, String content) throws javax.mail.MessagingException {
        try {
            MimeMessageHelper message = new MimeMessageHelper(defaultMailSender.createMimeMessage(), false);
            message.setSubject(subject);
            message.setTo(new InternetAddress(destinationEmail, name));
            message.setFrom(fromEmail, fromName);
            message.setText(content, true);
            MimeMailMessage msg = new MimeMailMessage(message);
            defaultMailSender.send(msg.getMimeMessage());
        } catch (UnsupportedEncodingException e) {
            throw new javax.mail.MessagingException("UnsupportedEncodingException", e);
        }
    }

    @Override
    public void sendRestoreEmail(String destinationEmail, String name, String content) throws javax.mail.MessagingException {
        sendEmail(destinationEmail, name, emailSettings.getVerificationEmailFileName(), emailSettings.getFromName(), emailSettings.getRestoreSubject(), content);
    }

}
