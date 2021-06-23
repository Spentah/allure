package hooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.PrinterPage;

import java.util.concurrent.TimeUnit;

public class Hooks {
    WebDriver driver;
    public MainPage main;
    WebDriverWait wait;
    public PrinterPage printer;

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver","D:\\beat\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        main = PageFactory.initElements(driver,MainPage.class);
        printer = PageFactory.initElements(driver, PrinterPage.class);


    }

//    @After
//    public void end() {
//        driver.quit();
//    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.avito.ru/");
        main.selectCategory()
            .sendText("Принтер")
            .chooseCity("Владивосток");
        printer.checkboxAndSearch()
                .takeExpensivePrinter();
    }
}