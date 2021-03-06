import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//input[@class='oct-button']");
    private By regisrButton = By.xpath("//a[@class='oct-button']");

    private By registeredText = By.xpath("//*[text()='Я уже зарегистрирован']");
    private By incorrectRegisteredData = By.xpath("//*[text()=' Неправильно заполнены поля E-Mail и/или пароль!']");


    public LoginPage inputUserName(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }
    public LoginPage inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage incorrectLoginCreds(String username, String password) {
        this.inputUserName(username);
        this.inputPassword(password);
        driver.findElement(submitButton).click();
        return new LoginPage(driver);
    }
    public String getRegisteredUserText() {
        return driver.findElement(registeredText).getText();
    }
    public String getErrorText() { //error text when login or password incorrect
        return driver.findElement(incorrectRegisteredData).getText();
    }
    public SignUpPage createAccount() { // redirecting to create account page
        driver.findElement(regisrButton).click();
        return new SignUpPage(driver);
    }

}
