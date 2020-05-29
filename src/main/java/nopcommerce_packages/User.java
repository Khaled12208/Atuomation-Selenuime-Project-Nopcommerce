package nopcommerce_packages;

/**
 * Hello world!
 *
 */
public class User {

	/****************************** private Variables *************************/
	protected String date_month;
	protected String email;
	protected String companyName;
	protected String gender;
	protected String firsrname;
	protected String lastName;
	protected String date_day;
	protected String date_year;
	protected String Password;

	/******************************
	 * Setter methods
	 *************************/

	public void set_date_month(Object month) {

		date_month = (String) month;

	}

	public void set_email(Object email_val) {

		this.email = (String) email_val;

	}
	public void set_companyName(Object companyName) {

		this.companyName = (String) companyName;

	}
	public void set_gender(Object gender) {

		this.gender = (String) gender;

	}

	public void set_firsrname(Object firsrname) {

		this.firsrname = (String) firsrname;

	}
	public void set_lastName(Object lastName) {

		this.lastName = (String) lastName;

	}
	public void set_date_day(Object date_day) {

		this.date_day = (String) date_day;

	}
	public void set_date_year(Object date_year) {

		this.date_year = (String) date_year;

	}
	public void set_Password(Object Password) {

		this.Password = (String) Password;

	}

	/***********************
	 * Getter methods
	 *
	 * @return
	 ********************/

	public String get_date_month() {

		return date_month;

	}

	public String get_email() {

		return email;

	}
	public String get_companyName() {

		return companyName;

	}
	public String get_gender() {

		return gender;

	}

	public String get_firsrname() {

		return firsrname;

	}
	public String get_lastName() {

		return lastName;

	}
	public String get_date_day() {

		return date_day;

	}
	public String get_date_year() {

		return date_year;

	}
	public String get_Password() {

		return Password;

	}

}
