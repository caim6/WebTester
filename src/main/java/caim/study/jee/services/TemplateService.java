package caim.study.jee.services;
import caim.study.jee.forms.UserForm;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;


public interface TemplateService {
    String getTemplateForEmail(UserForm form, String filename) throws FileNotFoundException, UnknownHostException;

    void sendVerificationEmail(UserForm form) throws FileNotFoundException, MessagingException;

    void sendRestoreEmail(UserForm form) throws FileNotFoundException, MessagingException;

}
