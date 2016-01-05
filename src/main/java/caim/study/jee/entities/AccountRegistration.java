package caim.study.jee.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by caim6 on 11.11.2015.
 */
@Entity
@Table(name = "account_registration", schema = "xgbua_web_tester")
public class AccountRegistration extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_account", unique=true, nullable=false)
    private Long idAccountRegistration;

    @Column(name="hash", nullable=false, length=255)
    private String hash;


    //bi-directional one-to-one association to Account
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_account", nullable=false)
    private Account account;

    public AccountRegistration() {
    }

    public Long getIdAccountRegistration() {
        return this.idAccountRegistration;
    }

    @Override
    @Transient
    public Serializable getId() {
        return getIdAccountRegistration();
    }

    public void setIdAccountRegistration(Long idAccount) {
        this.idAccountRegistration = idAccount;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
