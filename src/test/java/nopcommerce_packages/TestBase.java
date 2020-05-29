package nopcommerce_packages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public ThreadLocal<WebDriver> driver;

    protected Properties prop;
    String environment = System.getProperty("environment");

    @BeforeTest(alwaysRun = true)
    public WebDriver Browser_Init() throws IOException {
	String DriverPath;
	String PropertiesFilepath = System.getProperty("user.dir") + "\\Data\\URL.properties";
	FileInputStream file = new FileInputStream(PropertiesFilepath);
	prop = new Properties();
	prop.load(file);
	String browser = prop.getProperty("browser");
	String url = prop.getProperty("URL");
	if (browser.equals("chrome")) {

	    driver = new ThreadLocal<WebDriver>();

	    DriverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver1.exe";
	    System.setProperty("webdriver.chrome.driver", DriverPath);
	    driver.set(new ChromeDriver());

	} else if (browser.equals("firefox")) {
	    driver = new ThreadLocal<WebDriver>();

	    DriverPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver", DriverPath);
	    driver.set(new FirefoxDriver());

	} else if (browser.equals("IE")) {
	    driver = new ThreadLocal<WebDriver>();

	    DriverPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
	    System.setProperty("webdriver.ie.driver", DriverPath);
	    driver.set(new InternetExplorerDriver());

	} else {
	    System.out.println("Error ! Please Make sure you enter a valid brwoser name");

	}
	/* to make each every test cases wait befor faild the scripe */
	driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get().manage().window().maximize();
	driver.get().get(url);

	return driver.get();

    }

    @AfterTest(alwaysRun = true)
    public void Browser_Terdown() {

	driver.get().quit();

    }

}
