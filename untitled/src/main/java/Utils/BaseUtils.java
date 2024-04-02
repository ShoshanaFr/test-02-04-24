package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import page.objects.Menu.MenuHelper;
import page.objects.Table.TableHelper;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

public abstract class BaseUtils {
    public WebDriver driver;
    public ConfigReader configReader;
    public static TestReporter reporter;
    public TableHelper tableHelper = new TableHelper(this);
    public MenuHelper menuHelper = new MenuHelper(this);


    @BeforeClass(alwaysRun = true)
    public void setUpTest() throws Exception {
        configReader = new ConfigReader();

        reporter = new TestReporter();
        reporter.startReport(STR."\{System.getProperty("user.dir")}\{configReader.getReportFilePath()}\{Calendar.getInstance().getTimeInMillis()}.html");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + configReader.getChromeDriverPath());
        driver = new ChromeDriver();
    }

    public WebElement findElement(By by) {
        try {
            waitForLoad();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean clickOnElement(By by) {
        WebElement element;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            if (element != null) {
                element.click();
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public List<WebElement> findElements(By by) {
        waitForLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            throw e;
        }
    }

    public void waitForLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(120)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            });
        } catch (WebDriverException ignored) {
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        reporter.finishReport();
    }
}