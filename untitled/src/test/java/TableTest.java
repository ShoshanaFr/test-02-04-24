import Utils.BaseUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import page.objects.Table.TableLocator;

public class TableTest extends BaseUtils {

    @Test
    public void verifyTableCellText() {
        reporter.createTest("Verify Table");

        reporter.log("Navigate to HTML tables");
        driver.get(configReader.getTableUrl());

        reporter.log("Table cell text verification");
        WebElement table = findElement(TableLocator.TBL_CUSTOMERS);
        boolean result = tableHelper.verifyTableCellText(table, configReader.getSearchColumn(),
                configReader.getSearchText(), configReader.getReturnColumn(), configReader.getExpectedText());
        if (result) {
            reporter.passTest();
        } else {
            reporter.failTest();
        }
    }


}