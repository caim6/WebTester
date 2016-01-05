package caim.study.jee.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the account database table.
 */
@Entity
@Table(name = "account", schema = "xgbua_web_tester")
public class Account extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ACCOUNT_IDACCOUNT_GENERATOR", sequenceName = "ACCOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_IDACCOUNT_GENERATOR")
    @Column(name = "id_account", unique = true, nullable = false)
    private Long idAccount;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "login", nullable = false, length = 60)
    private String login;

    @Column(name = "name", length = 80)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "confirmed")
    private Boolean confirmed;


    @Column(name = "updated")
    private Timestamp updated;

    //bi-directional many-to-one association to AccountRole
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoles;


    public Account() {
    }

    public Long getIdAccount() {
        return this.idAccount;
    }

    @Override
    @Transient
    public Serializable getId() {
        return getIdAccount();
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Timestamp getUpdated() {
        return this.updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public List<AccountRole> getAccountRoles() {
        return this.accountRoles;
    }

    public void setAccountRoles(List<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }


    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }
}