package mark.butko.model.exceptions;

@SuppressWarnings("serial")
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
