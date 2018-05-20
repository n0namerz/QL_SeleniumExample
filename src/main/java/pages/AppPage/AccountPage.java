package pages.AppPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DefaultPage.BasePage;

/**
 * Страница личного кабинета, через нее можно получать доступ к различным разделам
 * внутри личного кабинета, например к письмам или контактному листу.
 */
public class AccountPage extends BasePage {
    private MessagesPage messagesPage;
    private ContactsPage contactsPage;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получение страницы с разделом "Письма".
     *
     * @return страницу как объект
     */
    public MessagesPage getMessagesPage() {
        String spanXpath = "//span[@data-name='ph-inbox']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(spanXpath))).click();
        if (messagesPage == null) {
            messagesPage = new MessagesPage(driver);
        }
        return messagesPage;
    }

    /**
     * Получение страницы с раздлом "Контакты".
     *
     * @return страницу как объект
     */
    public ContactsPage getContactsPage() {
        String spanXpath = "//span[@data-name='ph-addressbook']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(spanXpath))).click();
        if (contactsPage == null) {
            contactsPage = new ContactsPage(driver);
        }
        return contactsPage;
    }
}
