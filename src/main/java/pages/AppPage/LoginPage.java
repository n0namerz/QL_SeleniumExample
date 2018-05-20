package pages.AppPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DefaultPage.BasePage;
import steps.OnLoginPage;
import varEnums.MailDomains;

/**
 * Страница входа в аккаунт.
 */
public class LoginPage extends BasePage {
    private String pageURL = "https://e.mail.ru/login";
    private OnLoginPage stepsForLoginPage;

    /**
     * Возвращает класс с шагами объединяющими действия на этой странице.
     *
     * @return класс с наборами шагов
     */
    public OnLoginPage getSteps() {
        if (stepsForLoginPage == null) {
            stepsForLoginPage = new OnLoginPage(driver);
        }
        return stepsForLoginPage;
    }

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    /**
     * Открывает страницу в браузере.
     */
    public void getPage() {
        driver.get(pageURL);

    }

    /**
     * Переключение на iframe с полями для входа.
     */
    public void switchToLoginFrame() {
        String iframeXpath = "//iframe[contains(@src, 'https://account.mail.ru/login/')]";
        WebElement loginFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframeXpath)));
        driver.switchTo().frame(loginFrame);

    }

    /**
     * Ввод имени пользователя почтового ящика.
     *
     * @param username имя пользователя без домена
     */
    public void inputUsername(String username) {
        String inputXpath = "//input[@name='Username']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXpath))).sendKeys(username);

    }

    /**
     * Выбор домена почтового ящика из списка.
     *
     * @param domain домен из перечисления MailDomains
     */
    public void chooseDomain(MailDomains domain) {
        String dropdownXpath = "//div[@data-blockid='email_select']";
        String itemXpath = dropdownXpath + "//span[contains(., '" + domain.getDomain() + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemXpath))).click();

    }

    /**
     * Ввод паролья пользователя почтового ящика.
     *
     * @param password пароль пользователя
     */
    public void inputPassword(String password) {
        String inputXpath = "//input[@name='Password']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXpath))).sendKeys(password);
    }

    /**
     * Клик на кнопку входа в аккаунт.
     *
     * @return страницу аккаунта как объет
     */
    public AccountPage clickSubmit() {
        String buttonXpath = "//button[@data-name='submit']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath))).click();
        return new AccountPage(driver);
    }
}
