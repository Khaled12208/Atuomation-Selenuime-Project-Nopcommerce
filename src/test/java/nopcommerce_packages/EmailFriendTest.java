package nopcommerce_packages;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.UserLoginPage;
import services.DataReader;

public class EmailFriendTest extends TestBase {

    /****************** Global Data **************************************/
    protected UserLogin user = new UserLogin();
    protected JavascriptExecutor js;
    protected ProductPage obj;

    protected EmailFriendPage EFP;

    /*************** Contractor variables to init the driver *************/

    public EmailFriendTest() throws IOException {
	// this.driver = Browser_Init();
    }

    /************************* Tests Methods *****************************/
    // user login
    @Test(dataProvider = "dataRegestration")
    public void Successlgoin(UserLogin us) throws InterruptedException {

	HomePage home = new HomePage(driver.get());
	driver.set(home.login());
	UserLoginPage login = new UserLoginPage(driver.get());
	driver.set(login.login(us));
	Thread.sleep(10000);

    }

    // user logout

    @Test(dependsOnMethods = { "Successlgoin" })
    public void SelectItem() throws InterruptedException {
	js = (JavascriptExecutor) driver.get();
	HomePage home = new HomePage(driver.get(), js);
	String Product_name = "Apple MacBook Pro 13-inch";
	home.SelectPoduct_fromFeatued(Product_name);

    }

    // user logout

    @Test(dependsOnMethods = { "Successlgoin", "SelectItem" })
    public void EmailaProduct() throws InterruptedException, IOException {
	ProductEmail EmailFriend = new ProductEmail();
	obj = new ProductPage(driver.get());
	driver.set(obj.clickEmailProuct());
	EFP = new EmailFriendPage(driver.get());
	Thread.sleep(2000);
	EmailFriend.SetFriendEmail("3abaas@gmail.com");
	EmailFriend.SetMessage("Hellos Take alook at this product please");
	EFP.sendProduct_as_user(EmailFriend);

    }

    // user logout

    @Test(dependsOnMethods = { "Successlgoin", "SelectItem", "EmailaProduct" })
    public void logout() throws InterruptedException {
	HomePage home = new HomePage(driver.get());
	home.logout();

    }

    /****************** DataPwovidor ***************************************/

    @DataProvider(name = "dataRegestration")
    public Object[] dataRegestration() throws IOException, ParseException {

	DataReader data = new DataReader();
	HashMap<String, String> regData = data.logindata();
	user.set_email(regData.get("E-mail"));
	user.set_Password(regData.get("password"));
	Object user_data[] = new Object[1];
	user_data[0] = user;
	return user_data;
    }

}
