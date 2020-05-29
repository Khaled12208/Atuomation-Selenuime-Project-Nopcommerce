package Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

    /********************** locators Variables ************************/
    protected WebDriver driver;
    protected JavascriptExecutor js;
    By register = By.xpath("//a[contains(@href,'register')]");
    By login = By.xpath("//a[contains(@href,'login')]");
    By logout = By.xpath("//a[@class='ico-logout']");
    By seach_box = By.xpath("//input[@id='small-searchterms']");
    By seach_buttom = By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/div[2]/form[1]/input[2]");
    By links = By.xpath("//a[@href]");
    By contactus = By.xpath("//a[contains(@href,'contactus')]");
    By currency_select = By.xpath("//select[@id=\"customerCurrency\"]");
    By welcomeStatment = By.xpath("//h2[contains(text(),'Welcome to our store')]");
    By computer_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    By Electronics_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]");
    By Apparel_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Apparel')]");
    By Digital_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Digital downloads')]");
    By Books_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]");
    By Jewelry_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]");
    By Gift_menu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Gift Cards')]");
    By FeatredProduct = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]");

    /*************** Contractor to init the web driver ******************/
    public HomePage(WebDriver driver) {
	this.driver = driver;
    }

    public HomePage(WebDriver driver, JavascriptExecutor js) {
	this.driver = driver;
	this.js = js;
    }

    /********************* Methods ***********************************/
    // handling auto-suggestion search features
    public WebDriver AutoSug_Search(String data) throws InterruptedException {

	Send_Keys(driver.findElement(seach_box), data);
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	check_value_AutoSugg(driver.findElement(seach_box), js, data);

	return this.driver;
    }

    // handling search features
    public WebDriver Search(String data) {

	Send_Keys(driver.findElement(seach_box), data);
	click_Element(driver.findElement(seach_buttom));

	return this.driver;
    }

    // handling register button
    public WebDriver register() {
	WebElement register_buttom = driver.findElement(register);
	click_Element(register_buttom);

	return this.driver;
    }

    // handling login button
    public WebDriver login() {
	WebElement login_buttom = driver.findElement(login);
	click_Element(login_buttom);

	return this.driver;
    }

    // handling https links in the page
    public List<WebElement> linkssList() {

	return driver.findElements(links);
    }

    // handling check the linkes in the page
    public int Links(WebElement link) throws MalformedURLException, IOException {
	int response = 0;
	response = validatelinks(link);
	return response;
    }

    // handling contact us in the page
    public WebDriver get_contact_page() throws InterruptedException {

	WebElement contact = driver.findElement(contactus);
	Point location = contact.getLocation();
	System.out.println(location);
	String Script = "window.scrollBy" + location + ";";

	System.out.println(Script);

	js.executeScript(Script);
	Thread.sleep(1000);
	click_Element(contact);

	return driver;
    }

    // handling currency selection in the page
    public String currency_select(String value) {
	Select s = new Select(driver.findElement(currency_select));
	s.selectByVisibleText(value);

	return s.getFirstSelectedOption().getText();

    }

    // handling verfity welcome statment in the page
    public String verfiy_Wecome() throws InterruptedException {
	WebElement welcome_stat = driver.findElement(welcomeStatment);
	Point location = welcome_stat.getLocation();
	String Script = "window.scrollBy" + location + ";";
	js.executeScript(Script);
	Thread.sleep(1000);

	return welcome_stat.getText();
    }

    // handling main menue elements
    public HashMap<String, WebElement> main_menu() {
	HashMap<String, WebElement> main_men = new HashMap<String, WebElement>();

	main_men.put("Computers", driver.findElement(computer_menu));
	main_men.put("Electronics", driver.findElement(Electronics_menu));
	main_men.put("Apparel", driver.findElement(Apparel_menu));
	main_men.put("Digital", driver.findElement(Digital_menu));
	main_men.put("Books", driver.findElement(Books_menu));
	main_men.put("Jewelry", driver.findElement(Jewelry_menu));
	main_men.put("Gift", driver.findElement(Gift_menu));

	return main_men;
    }

    public WebDriver SelectPoduct_fromFeatued(String product) throws InterruptedException {

	WebElement produut = driver.findElement(FeatredProduct);
	WebElement Wbproduct = produut.findElement(By.xpath("//a[contains(text(),'" + product + "')]"));
	Point location = Wbproduct.getLocation();
	String Script = "window.scrollBy" + location + ";";
	js.executeScript(Script);
	click_Element(Wbproduct);
	return driver;
    }

    // handling the logout functionality
    public void logout() {
	WebElement logoutButton = driver.findElement(logout);
	click_Element(logoutButton);

    }

}
