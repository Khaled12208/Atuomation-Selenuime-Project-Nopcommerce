package services;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReporterNG {

    protected ExtentReports report;

    public ExtentReports get_report(String environment) {

	if (!(environment == null)) {
	    environment = "indix";
	}
	String Path = System.getProperty("user.dir") + "\\Reports\\" + environment + ".html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
	reporter.config().setReportName("Nopcommerce.com Automation Results");
	reporter.config().setDocumentTitle("Tester : Khaled farh ");

	// to exectue the test report
	report = new ExtentReports();

	report.attachReporter(reporter);
	report.setSystemInfo("Tester", "Khaled M. Farh");

	return report;
    }

}
