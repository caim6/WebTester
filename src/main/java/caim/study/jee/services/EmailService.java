package caim.study.jee.services;


public interface EmailService {
    void sendVerificationEmail(String destinationEmail,String name,String content) throws javax.mail.MessagingException;

    void sendEmail(String destinationEmail,String name,String fromEmail,String fromName,
                   String subject,String content) throws javax.mail.MessagingException;

    void sendRestoreEmail(String destinationEmail, String name, String content) throws javax.mail.MessagingException ;

}
