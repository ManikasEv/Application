package Validations;

public class ValidationClass {


	public boolean UsernameReturner(String username) {
		if(username.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean PasswordReturner(String password) {
		if(password.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean EmailReturner(String email) {
		if(email.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean TelephoneReturner(String telephone) {
		if(telephone.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	public boolean AddressReturner(String address) {
		if(address.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

}
