package qa_scooter.ru.Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Objects;

public class RegistrationPreparation {
    private final WebDriver driver;

    //Первая точка входа
    private final By OpenTheOrdersTab = By.className("Button_Button__ra12g");


    //Первая часть анкеты
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привести заказ']");
    private final By undergroundField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");


    //Кнопка "Далее"
    private final By buttonMiddle = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //Вторая часть анкеты
    private final By buttonInput_InputNextField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By poleDropdownNextField = By.className("Dropdown-arrow");
    private final By buttonToOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By OrderModal = By.className("Order_Modal__YZ-d3");
    private final By OrderModalText = By.className("Order_ModalHeader__3FDaJ");


    //Кнопка "Да" в открывающемся модальном окне
    private final By ButtonMiddleYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");


    //Вторая точка входа
    private final By buttonFinishButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']//button");

    public RegistrationPreparation(WebDriver driver){
        this.driver = driver;
    }

    //Ожидание загрузки страницы и первой точки входа
    public void expectationTheOrdersButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(OpenTheOrdersTab));
    }

    //Первая точка входа(в начале страницы)
    public void OpenTheOrdersTabClick() {
        driver.findElement(OpenTheOrdersTab).click();
    }

    //Вторая точка входа(внизу страници)
    public void buttonFinishButton() {
        driver.findElement(buttonFinishButton).click();
    }

    //Скрол до кнопки заказа
    public void scrolOnFinishButton() {
        WebElement element = driver.findElement(buttonFinishButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    //Заполнение первого листа анкеты
    public void allField(String name, String surname, String address, String underground, String telephone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(undergroundField).sendKeys(underground);
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    //Кнопка "Далее"
    public void nextButton() {
        driver.findElement(buttonMiddle).click();
    }

    //Ожидание загрузки второго листа анкеты
    public void expectationButtonInput_Input() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonInput_InputNextField));
    }

    //Заполнение второго листа анкеты
    public void allNextField(String data, By days, By color) {
        driver.findElement(buttonInput_InputNextField).sendKeys(data);
        driver.findElement(poleDropdownNextField).click();
        driver.findElement(days).click();
        driver.findElement(color).click();
        driver.findElement(buttonToOrder).click();
    }


    //Ожидание прогрузки модального окна
    public void expectationOrderModal() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(OrderModal));
    }

    public boolean OrderModalMeaning() {
        return Objects.equals(driver.findElement(OrderModalText).getText(), "Заказ оформлен");
    }

}
