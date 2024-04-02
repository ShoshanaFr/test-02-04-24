package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReporter {
    private ExtentReports extent;
    private ExtentTest test;

    public void startReport(String filePath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public void log(String message) {
        test.log(Status.INFO, message);
    }

    public void passTest() {
        test.pass("Test passed");
    }

    public void failTest() {
        test.fail("Test failed");
    }

    public void finishReport() {
        extent.flush();
    }
}