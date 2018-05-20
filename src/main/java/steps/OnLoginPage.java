package steps;

import org.openqa.selenium.WebDriver;
import pages.AppPage.AccountPage;
import pages.AppPage.LoginPage;
import varEnums.MailDomains;

/**
 * Класс содержит более высокоуровневые действия пользователя на странице входа в аккаунт.
 */
public class OnLoginPage extends LoginPage {
    private LoginPage loginPage;

    public OnLoginPage(WebDriver driver) {
        super(driver);
        this.loginPage = new LoginPage(driver);
    }

    /**
     * Метод описывает цепочку действий пользователя для входа в аккаунт.
     * @param username имя пользователя без домена
     * @param mailDomains доменное имя почты из перечисления MailDomains
     * @param password пароль пользователя
     * @return страницу аккаунта как объект
     */
    public AccountPage login(String username, MailDomains mailDomains, String password) {
        loginPage.switchToLoginFrame();
        loginPage.inputUsername(username);
        loginPage.chooseDomain(mailDomains);
        loginPage.inputPassword(password);
        return loginPage.clickSubmit();
    }
}
