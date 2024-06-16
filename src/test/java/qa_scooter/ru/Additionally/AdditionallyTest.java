package qa_scooter.ru.Additionally;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class AdditionallyTest {

    private WebDriver driver;

    @Test
    public void buttonScooter() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        AdditionallyClass driverAccordion = new AdditionallyClass(driver);
        driverAccordion.buttonScooterClick();
        driverAccordion.buttonScooterTest();
    }

    @Test
    public void buttonLogoYandex() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String expectedURL = "https://dzen.ru/?yredirect=true";
        AdditionallyClass driverAccordion = new AdditionallyClass(driver);
        driverAccordion.logoYandexClick();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String redirectURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,redirectURL);
    }
}
