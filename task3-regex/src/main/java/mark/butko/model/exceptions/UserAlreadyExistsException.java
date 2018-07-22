package mark.butko.model.exceptions;

@SuppressWarnings("serial")
/**
 * Exception thrown if user email is already in Notebook
 * 
 * @author BUtko Mark
 *
 */
public class UserAlreadyExistsException extends Exception {

	private String email;

	public UserAlreadyExistsException(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
