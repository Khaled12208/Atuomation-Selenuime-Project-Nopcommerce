package nopcommerce_packages;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserLoginPage;
import services.DataReader;

public class UserLoginTest extends TestBase {

    /****************** Global Data **************************************/
    protected UserLogin user = new UserLogin();

    /*************** Contractor variables to init the driver *************/

    public UserLoginTest() throws IOException {
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

    @Test(dependsOnMethods = { "Successlgoin" }, groups = { "Smook" })
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
