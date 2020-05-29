package nopcommerce_packages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends TestBase {

    /**************** global variables *********************/

    protected HomePage ob;
    protected JavascriptExecutor js;

    /***** Contractor variables to init the driver *********************/

    public HomePageTest() throws IOException {
	// this.driver = Browser_Init();
    }

    /**************** Contractor variables *********************/

    @Test(groups = { "Smook" })
    public void welcomeStatment() throws InterruptedException {

	js = (JavascriptExecutor) driver.get();
	ob = new HomePage(driver.get(), js);
	String value_presented = ob.verfiy_Wecome();
	Assert.assertEquals(value_presented, "Welcome to our store");
    }

    @Test(groups = { "Smook" })
    public void link_test() throws MalformedURLException, IOException {

	ob = new HomePage(driver.get());
	List<WebElement> links = ob.linkssList();
	// Iterator<WebElement> itr = links.iterator();
	System.out.println("number of links is " + links.size());

    }

    @Test(dependsOnMethods = { "welcomeStatment", "link_test" }, groups = { "Smook" })
    public void Actions_overMainMenue() {

	ob = new HomePage(driver.get());
	HashMap<String, WebElement> Menu = ob.main_menu();
	Actions action = new Actions(driver.get());
	WebElement One = Menu.get("Computers");
	action.moveToElement(One).click().build().perform();
	;

    }

    @Test(dataProvider = "currency", groups = { "Smook" })
    public void cureency_validate(String value) throws MalformedURLException, IOException {

	String[] Crrency_avilable = { "US Dollar", "Euro" };
	List<String> Crrency_avilableList = Arrays.asList(Crrency_avilable);

	ob = new HomePage(driver.get());
	String Selected_value = ob.currency_select(value);
	Assert.assertTrue(Crrency_avilableList.contains(Selected_value));
    }

    @DataProvider(name = "currency")
    public Object[] get_currency() {

	Object[] search = new Object[2];
	search[0] = "US Dollar";
	search[1] = "Euro";
	return search;
    }

}
