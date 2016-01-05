package nedis.study.jee.services;

/**
 * Created by caim6 on 02.12.2015.
 */
public interface EmailService {
    void sendVerificationEmail(String destinationEmail,String name,String content) throws javax.mail.MessagingException;

    void sendEmail(String destinationEmail,String name,String fromEmail,String fromName,
                   String subject,String content) throws javax.mail.MessagingException;

    void sendRestoreEmail(String destinationEmail, String name, String content) throws javax.mail.MessagingException ;

}
