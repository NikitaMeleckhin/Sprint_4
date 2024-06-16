package qa_scooter.ru.Additionally;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
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
import static org.junit.Assert.assertEquals;

public class AdditionallyTest {

    private WebDriver driver;

    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        this.driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void buttonScooter() {
        setDriver();
        AdditionallyClass driverAccordion = new AdditionallyClass(driver);
        driverAccordion.buttonScooterClick();
        assertThat(driverAccordion.buttonScooterTest(), is(true));
    }

    @Test
    public void buttonLogoYandex() throws InterruptedException {
        setDriver();
        String expectedURL = "https://dzen.ru/?yredirect=true";
        AdditionallyClass driverAccordion = new AdditionallyClass(driver);
        driverAccordion.logoYandexClick();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String redirectURL = driver.getCurrentUrl();
        assertThat(redirectURL, is(expectedURL));
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
