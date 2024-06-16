package qa_scooter.ru.Registration;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import qa_scooter.ru.Registration.RegistrationPreparation;

@RunWith(Parameterized.class)
public class RegistrationTest {

    private WebDriver driver;

    //Первый лист анкеты
    private final String name; //Имя пользователя
    private final String surname; //Фамилия пользователя

    private final String address; //Адрес пользователя

    private final String underground; //Станция метро

    private final String telephone; //Телефон

    //Второй лист анкеты
    private final String data; //Дата заказа
    private final By days; //День заказа
    private final By color; //Цвет самоката


    public RegistrationTest(String name, String surname, String address, String underground, String telephone, String data, By days, By color) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.underground = underground;
        this.telephone = telephone;

        this.data = data;
        this.days = days;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {"Руслан", "Абиев","Хабаровск Виноградово 21","нет","+79246666665","08.09.2024",By.xpath(".//div[@class='Dropdown-menu']//div[1]"), By.id("black")},
                {"Мария", "Хриптукова","Москва Запарина 34","Баумонская","+79246666667", "10.09.2024",By.xpath(".//div[@class='Dropdown-menu']//div[2]"), By.id("grey")},
                {"Егор", "Кузьминых","Хабаровск Волочаевская 12","нет","+79246666623", "11.09.2024",By.xpath(".//div[@class='Dropdown-menu']//div[3]"), By.id("black")},
        };
    }

    @Test
    public void Test_1() {
        //OpenTheOrdersTab
        //Первая точка входа
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        RegistrationPreparation driverR = new RegistrationPreparation(driver);
        //Ожидание прогрузки страницы и клик по первой кнопки "Заказать"
        driverR.expectationTheOrdersButton();
        driverR.OpenTheOrdersTabClick();
        //Заполнение первого листа анкеты и клик по кнопки "Далее"
        driverR.allField(name, surname, address, underground, telephone);
        driverR.nextButton();
        //Ожидание прогрузки второго листа анкеты и его заполнение
        driverR.expectationButtonInput_Input();
        driverR.allNextField(data, days, color);
        //Ожидание модального окна и кнопка "Да"
        driverR.expectationOrderModal();
        driverR.ButtonMiddleYes();
    }

    @Test
    public void Test_2() {
        //buttonFinishButton()
        //Вторая точка входа
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        RegistrationPreparation driverR = new RegistrationPreparation(driver);
        //Ожидание прогрузки страницы, скрол до кнопки с последующим нажатием
        driverR.expectationTheOrdersButton();
        driverR.scrolOnFinishButton();
        driverR.buttonFinishButton();
        //Заполнение первого листа анкеты
        driverR.allField(name, surname, address, underground, telephone);
        driverR.nextButton();
        //Заполнение второго листа анкеты
        driverR.expectationButtonInput_Input();
        driverR.allNextField(data, days, color);
        //Ожидание модального окна и кнопка "Да"
        driverR.expectationOrderModal();
        driverR.ButtonMiddleYes();
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
