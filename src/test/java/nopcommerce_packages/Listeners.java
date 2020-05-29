package nopcommerce_packages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import services.ScreenShoots;
import services.TestReporterNG;

public class Listeners extends TestBase implements ITestListener {

    /***************** Global Variabeles *********************/
    TestReporterNG reporter = new TestReporterNG();
    ScreenShoots screen = new ScreenShoots();
    ExtentReports Report = reporter.get_report(environment);
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    /***************** TestNG implemntation *********************/

    public void onTestStart(ITestResult result) {
	test = Report.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
	extentTest.get().log(Status.PASS, "TestPass");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void onTestFailure(ITestResult result) {

	extentTest.get().fail(result.getThrowable());
	ThreadLocal<WebDriver> thread;
	WebDriver driver = null;
	String TestMethodName = result.getMethod().getMethodName();

	try {
	    thread = (ThreadLocal) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	    driver = thread.get();
	    System.out.println("heler is the fuiler " + driver);
	} catch (Exception e) {
	    e.printStackTrace();

	}

	try {
	    String Path = screen.getScreenShotPath(TestMethodName, driver);
	    extentTest.get().addScreenCaptureFromPath(Path, TestMethodName);

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
	// TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub

	Report.flush();

    }

}
