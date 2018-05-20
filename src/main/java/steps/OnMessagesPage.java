package steps;

import org.openqa.selenium.WebDriver;
import pages.AppPage.AccountPage;
import pages.AppPage.MessagesPage;

/**
 * Класс содержит более высокоуровневые действия пользователя в разделе с письмами на странице аккаунта.
 */
public class OnMessagesPage extends MessagesPage {
    private MessagesPage messagesPage;

    public OnMessagesPage(WebDriver driver) {
        super(driver);
        this.messagesPage = new AccountPage(driver).getMessagesPage();
    }

    /**
     * Метод описывает цепочку действий пользователя для создания нового сообщения.
     * @param to полный e-mail адресата
     * @param subject тема сообщения
     * @param text текст сообщения
     */
    public void createNewMessage(String to, String subject, String text) {
        messagesPage.clickNewMessage();
        messagesPage.inputTo(to);
        messagesPage.inputSubject(subject);
        messagesPage.inputText(text);
        messagesPage.clickSend();
    }
}
