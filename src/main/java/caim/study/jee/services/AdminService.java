package caim.study.jee.services;

import caim.study.jee.entities.Account;
import caim.study.jee.forms.admin.AdminForm;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;


public interface AdminService {

     List<Account> loadAllUser();

     Account getAccount(Long userId);

    @Transactional
    void updateUser(Long userId, AdminForm form);

    void copyFormToUser(AdminForm form, Account account);

    void deleteUser(Long userId);

    List<String> getRoles(Account user);

    AdminForm getAdminForm(Model model, Account user);
}
