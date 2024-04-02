package page.objects.Table;

import Utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHelper {

    private final BaseUtils BU;

    public TableHelper(BaseUtils baseUtils) {
        this.BU = baseUtils;
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        List<WebElement> rows = table.findElements(TableLocator.ROWS_IN_CUSTOMERS_TABLE);
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(TableLocator.COLS_IN_ROW_CUSTOMERS_TABLE);
            if (!columns.isEmpty()) {
                try {
                    if (columns.get(searchColumn - 1).getText().equals(searchText)) {
                        return columns.get(returnColumnText - 1).getText();
                    }
                }
                catch (IndexOutOfBoundsException e){
                    BaseUtils.reporter.log(e.getMessage());
                    BaseUtils.reporter.failTest();
                    throw e;
                }
            }
        }
        return null;
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String actualText = getTableCellText(table, searchColumn, searchText, returnColumnText);
        return actualText.equals(expectedText) && actualText != null;
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        WebElement cell = table.findElement(By.xpath("//tr[td[" + (searchColumn) + "][text()='" + searchText + "']]/td[" + (returnColumnText) + "]"));
        return cell.getText();
    }
}