package qa_scooter.ru.Drop_downText;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class TextDropout {

    private WebDriver driver;

    //Раскрывающийся блок
    public By locator;

    //Выпадающий текст
    public By locatorlabelledby;

    public TextDropout(By locator, By locatorlabelledby) {
        this.locator = locator;
        this.locatorlabelledby = locatorlabelledby;
    }

    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        this.driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{ //1. Раскрывающийся блок 2. Выпадающий текст
                {By.id("accordion__heading-0"), By.xpath(".//div[@aria-labelledby='accordion__heading-0']")},
                {By.id("accordion__heading-1"), By.xpath(".//div[@aria-labelledby='accordion__heading-1']")},
                {By.id("accordion__heading-2"), By.xpath(".//div[@aria-labelledby='accordion__heading-2']")},
                {By.id("accordion__heading-3"), By.xpath(".//div[@aria-labelledby='accordion__heading-3']")},
                {By.id("accordion__heading-4"), By.xpath(".//div[@aria-labelledby='accordion__heading-4']")},
                {By.id("accordion__heading-5"), By.xpath(".//div[@aria-labelledby='accordion__heading-5']")},
                {By.id("accordion__heading-6"), By.xpath(".//div[@aria-labelledby='accordion__heading-6']")},
                {By.id("accordion__heading-7"), By.xpath(".//div[@aria-labelledby='accordion__heading-7']")},
        };
    }


    @Test
    public void TextDropoutTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
//        driver.get("https://qa-scooter.praktikum-services.ru/");
        setDriver();
        AccordionTestClass driverAccordion = new AccordionTestClass(driver);
        //Ожидание загрузки элемента
        driverAccordion.expectationHeading(locator);
        //Пролистывание до элемента
        driverAccordion.scrolOnHeading(locator);
        //Клик по элементу
        driverAccordion.searchHeading(locator);
        //Проверка выпадающего текста на наличие
        assertThat(driverAccordion.appearedlabelledby(locatorlabelledby), is(true));
    }



    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
