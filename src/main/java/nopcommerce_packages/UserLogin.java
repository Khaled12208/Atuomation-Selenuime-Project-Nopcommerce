package nopcommerce_packages;

public class UserLogin {

    protected String email;
    protected String Password;

    public void set_email(Object email_val) {

	this.email = (String) email_val;

    }

    public void set_Password(Object Password) {

	this.Password = (String) Password;

    }

    public String get_email() {

	System.out.println(email);

	return this.email;

    }

    public String get_Password() {

	return this.Password;

    }

}
