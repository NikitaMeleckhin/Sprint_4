package qa_scooter.ru.Additionally;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdditionallyClass {

    private final WebDriver driver;

    //
    private final By buttonScooter = By.className("Header_LogoScooter__3lsAR");
    private final By appApp = By.className("App_App__15LM-");


    //
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");

    public AdditionallyClass(WebDriver driver) {this.driver = driver;}


    //Проверка кнопки "Самокат"
    public void buttonScooterClick() {
        driver.findElement(buttonScooter);
    }
    public boolean buttonScooterTest(){
        return driver.findElement(appApp).isDisplayed();
    }


    //
    public void logoYandexClick() {
        driver.findElement(logoYandex).click();
    }
}
