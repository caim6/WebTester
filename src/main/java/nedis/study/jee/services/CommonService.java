package nedis.study.jee.services;

import com.restfb.types.User;
import nedis.study.jee.entities.Account;
import nedis.study.jee.entities.Role;
import nedis.study.jee.exceptions.InvalidUserInputException;
import nedis.study.jee.forms.UserForm;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author nedis
 * @version 1.0
 */
public interface CommonService {

	Account login (String email, String password, int role) throws InvalidUserInputException;

	Account login (User user) throws InvalidUserInputException, FileNotFoundException, MessagingException, UnknownHostException;

	Account signUp (UserForm form, boolean sendVerificationEmail) throws InvalidUserInputException, MessagingException, FileNotFoundException;

	Account getLoginAccount();

	List<Role> listAllRoles();

	@Transactional
	Account addAccount(UserForm form);

	void updateAccount(Account account);

	@Transactional
	void initRoles(List<String> checkRoles, Account a);
}
