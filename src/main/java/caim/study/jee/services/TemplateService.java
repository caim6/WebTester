package caim.study.jee.services;
import caim.study.jee.forms.UserForm;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;

/**
 * Created by caim6 on 01.12.2015.
 */
public interface TemplateService {
    String getTemplateForEmail(UserForm form, String filename) throws FileNotFoundException, UnknownHostException;

    void sendVerificationEmail(UserForm form) throws FileNotFoundException, MessagingException;

    void sendRestoreEmail(UserForm form) throws FileNotFoundException, MessagingException;

}