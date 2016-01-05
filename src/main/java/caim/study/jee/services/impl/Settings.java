package caim.study.jee.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by caim6 on 02.12.2015.
 */
@Service
public class Settings {

    @Value("${template.email.fromname}")
    private String emailName;
    @Value("${template.email.subject}")
    private String subject;
    @Value("${template.restore.filename}")
    private String restoreFileName;
    @Value("${template.email.subject}")
    private String restoreSubject;
    private String port;

    @Value("${template.email.filename}")
    private String emailReplay;

    public String getVerificationEmailFileName() {
        return emailReplay;
    }

    public void setVerificationEmailReplay(String emailReplay) {
        this.emailReplay = emailReplay;
    }

    public String getEmailFileName() {
        return emailName;
    }

    public void setEmailFileName(String emailFileName) {
        this.emailName = emailFileName;
    }


    public String getPort() {
        return port;
    }

    public void setHost(String port) {
        this.port = port;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    private String fromName;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRestoreFileName(String restoreFileName) {
        this.restoreFileName = restoreFileName;
    }

    public String getRestoreFileName() {
        return restoreFileName;
    }

    public void setRestoreSubject(String restoreSubject) {
        this.restoreSubject = restoreSubject;
    }

    public String getRestoreSubject() {
        return restoreSubject;
    }

    public void setPort(String port) {
        this.port = port;
    }


    public void setEmailReplay(String emailReplay) {
        this.emailReplay = emailReplay;
    }

    public String getEmailReplay() {
        return emailReplay;
    }
}
