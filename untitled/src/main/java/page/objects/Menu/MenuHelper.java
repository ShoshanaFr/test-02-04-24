package page.objects.Menu;

import Utils.BaseUtils;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class MenuHelper {
    private BaseUtils BU;

    public MenuHelper(BaseUtils baseUtils) {
        this.BU = baseUtils;
    }

    public boolean clickOnMenuItem(String menuItem) {
        List<String> items = Arrays.asList(menuItem.split(";"));
        return clickOnMenuItem(items.get(0), items.get(1));
    }

    public boolean clickOnMenuItem(String menuItem, String subMenuItem) {
        boolean result = BU.clickOnElement(By.xpath("//li[@class='dropdown']/*[contains(text(),'" + menuItem + "')]"));
        return result && BU.clickOnElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'" + subMenuItem + "')]"));
    }
}
