package qa_scooter.ru.Drop_downText;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccordionTestClass {
    private WebDriver driver;


    public AccordionTestClass(WebDriver driver){
        this.driver = driver;
    }

    //Поиск и клик по элементу
    public void searchHeading(By heading) {
        driver.findElement(heading).click();
    }

    //Ожидание элемента на странице
    public void expectationHeading(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Скрол до нужного элемента
    public void scrolOnHeading(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    //Проверка на выпадение текстового поля
    public void  appearedlabelledby(By locatorlabelledby) {
        driver.findElement(locatorlabelledby).isDisplayed();
    }

}
