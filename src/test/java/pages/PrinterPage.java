package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PrinterPage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor jse;

    public PrinterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        this.jse = jse;
    }//label[@data-marker='delivery-filter']
    //span[@data-marker='delivery-filter/text']
    @FindBy (xpath = "//div[@data-marker='fieldset/d']")
    private WebElement deliveryCheckbox;
    //input[@data-marker='delivery-filter/input']
    @FindBy (xpath = "//button[@data-marker='search-filters/submit-button']")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='index-topPanel-1F0TP']//select[@class='select-select-3CHiM']")
    private WebElement searchOptions;



    public PrinterPage checkboxAndSearch() throws InterruptedException {
        if (!deliveryCheckbox.isSelected()) {
            Thread.sleep(3000);
//            Actions actions = new Actions(driver);
//            actions.moveToElement(deliveryCheckbox).click().build().perform();
            deliveryCheckbox.click();
        }

        searchButton.click();
        Select select = new Select(searchOptions);
        select.selectByValue("2");
        return this;
    }

    public PrinterPage takeExpensivePrinter() {
        List<WebElement> printers = driver.findElements(By.xpath("//a[@data-marker='item-title']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-marker='item-title']")));
        for (int i = 0; i < 3; i++) {
            System.out.println(printers.get(i).getAttribute("outerText"));
        }
        return this;
    }

}
