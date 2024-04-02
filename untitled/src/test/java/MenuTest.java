import Utils.BaseUtils;
import org.testng.annotations.Test;
import page.objects.Menu.MenuHelper;

public class MenuTest extends BaseUtils {

    @Test
    public void clickOnItemInMenuTest() {
        reporter.createTest("Verify Menu");

        reporter.log("Navigate to GURU99 demo site");
        driver.get(configReader.getMenuUrl());

        reporter.log("Click on menu and sub menu item");
        boolean result = menuHelper.clickOnMenuItem(STR."\{configReader.getMenuItem()};\{configReader.getSubMenuItem()}");
        if (result) {
            reporter.passTest();
        } else {
            reporter.failTest();
        }
    }
}
