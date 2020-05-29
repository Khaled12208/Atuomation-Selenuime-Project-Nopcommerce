package nopcommerce_packages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase {

    /**************** global variables ********************/
    protected HomePage page;
    protected ContactUsPage contact;
    protected JavascriptExecutor js;

    /******************** Contractor *********************/
    public ContactUsTest() throws IOException {
	// this.driver = Browser_Init();

    }

    /******************* Test *************************/
    @Test(groups = { "Smook" })
    public void contact_us() throws InterruptedException {
	// get the contact page
	js = (JavascriptExecutor) driver.get();
	page = new HomePage(driver.get(), js);
	driver.set(page.get_contact_page());
	// enter the data requred
	contact = new ContactUsPage(driver.get());
	contact.valid_send_Enquire();

    }

}
