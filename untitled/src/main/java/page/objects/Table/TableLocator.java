package page.objects.Table;

import org.openqa.selenium.By;

public class TableLocator {
    public static final By TBL_CUSTOMERS = By.id("customers");
    public static final By ROWS_IN_CUSTOMERS_TABLE = By.cssSelector("#customers tr");
    public static final By COLS_IN_ROW_CUSTOMERS_TABLE = By.cssSelector("td");

}
