import org.testng.Assert;
import org.testng.annotations.*;
public class LoginPageTest extends BaseTest{
    LoginPage loginPage;

    @BeforeMethod
    public void SetUpLoginPage(){
        driver.get(PAGE_LINK + "login/");
        loginPage = new LoginPage(driver);
    }
    @Test
    public void loginWithEmptyCreds(){
        loginPage.incorrectLoginCreds("", "");
        Assert.assertEquals(loginPage.getErrorText(), "Неправильно заполнены поля E-Mail и/или пароль!");
    }
    @Test
    public void loginWithIncorrectCreds(){
        loginPage.incorrectLoginCreds(WRONG_LOGIN, WRONG_PASSWORD);
        Assert.assertEquals(loginPage.getErrorText(), "Неправильно заполнены поля E-Mail и/или пароль!");
    }
    @Test
    public void signUpPageRedirectTest(){
        SignUpPage signUpPage = loginPage.createAccount();
        Assert.assertEquals(signUpPage.getHeaderText(), "Быстрая регистрация");
    }

}
