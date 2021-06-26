package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (xpath = "//select[@name='category_id']")
    private WebElement categorySelect;

    @FindBy (xpath = "//input[@placeholder='Поиск по объявлениям']")
    private WebElement textField;

    @FindBy (xpath = "//div[@class='main-text-2PaZG']")
    private WebElement cityField;

    @FindBy (xpath = "//input[@placeholder='Город, регион или Россия']")
    private WebElement city;

    @FindBy (xpath = "//li[@data-marker='suggest(0)']")
    private WebElement newCity;

    @FindBy (xpath = "//button[@data-marker='popup-location/save-button']")
    private WebElement button;

    public MainPage selectCategory() {
        Select select = new Select(categorySelect);
        select.selectByValue("99");
        return this;
    }

    public void goTo() {
        driver.get("https://www.avito.ru/");
    }

    public MainPage sendText(String text) {
        textField.sendKeys(text);
        return this;
    }

    public void cityField() {
        cityField.click();
    }

    public MainPage chooseCity(String text) {
        try {
            city.sendKeys(text);
            Thread.sleep(2000);
            newCity.click();


        } catch (Exception e) {
            e.printStackTrace();
        } return this;
    }

    public void buttonClick() {
        button.click();
    }
}

