package nopcommerce_packages;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.UserRegestration;
import services.DataReader;

public class UserRegestrationTest extends TestBase {

    /*************** Global Variables *******************/
    protected User user = new User();

    /***** Contractor variables to init the driver *********************/

    public UserRegestrationTest() throws IOException {
	// this.driver = Browser_Init();
    }

    /***** test *****************************************************/
    @Test(dataProvider = "Regestration")
    public void SuccessRegestration(User us) throws InterruptedException {
	HomePage home = new HomePage(driver.get());
	driver.set(home.register());
	UserRegestration reg = new UserRegestration(driver.get());
	reg.registration(us);

    }

    @DataProvider(name = "Regestration")
    public Object[] dataRegestration() throws IOException, ParseException {

	DataReader data = new DataReader();
	HashMap<String, Object> regData = data.regestrationData();
	user.set_companyName(regData.get("company"));
	user.set_date_day(regData.get("Day"));
	user.set_date_month(regData.get("Month"));
	;
	user.set_date_year(regData.get("Year"));
	user.set_email(regData.get("E-Mail"));

	System.out.println(regData.get("E-Mail"));
	user.set_firsrname(regData.get("firsrname"));
	user.set_gender(regData.get("gender"));
	user.set_lastName(regData.get("lastnem"));
	user.set_Password(regData.get("Pass"));
	Object user_data[] = new Object[1];
	user_data[0] = user;
	return user_data;
    }

}
