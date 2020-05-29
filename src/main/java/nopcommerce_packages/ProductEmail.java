package nopcommerce_packages;

public class ProductEmail {

    /******************** data **********************/
    protected String MyEmail;
    protected String FriendEmail;
    protected String Message;

    /******************** data methods **********************/

    public void SetMyEmail(String MyEmail) {
	this.MyEmail = MyEmail;
    }

    public void SetFriendEmail(String FriendEmail) {
	this.FriendEmail = FriendEmail;
	System.out.println(this.FriendEmail);
    }

    public void SetMessage(String Message) {

	this.Message = Message;
	System.out.println(this.Message);

    }

    public String GetMyEmail() {

	return MyEmail;
    }

    public String GetFriendEmail() {

	return FriendEmail;
    }

    public String GetMessage() {

	return Message;
    }

}
