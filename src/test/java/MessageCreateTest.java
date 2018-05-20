import org.junit.Test;

import static junit.framework.TestCase.*;

import pages.AppPage.AccountPage;
import pages.AppPage.LoginPage;
import pages.AppPage.MessagesPage;
import varEnums.MailDomains;

/**
 * 2 теста проверяющих одно и то же.
 * <p>
 * Шаги:
 * Вход в учетную запись почтового ящика.
 * Создание и отправка сообщения.
 */
public class MessageCreateTest extends BaseTest {
    private static final String USERNAME = "";
    private static final MailDomains DOMAIN = MailDomains.MAILRU;
    private static final String PASSWORD = "";
    private static final String SEND_TO = "";
    private static final String SUBJECT = "";
    private static final String TEXT = "";

    @Test
    public void loginAndCreateMessage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getPage();
        loginPage.switchToLoginFrame();
        loginPage.inputUsername(USERNAME);
        loginPage.chooseDomain(DOMAIN);
        loginPage.inputPassword(PASSWORD);

        AccountPage accountPage = loginPage.clickSubmit();

        MessagesPage messagesPage = accountPage.getMessagesPage();
        messagesPage.clickNewMessage();
        messagesPage.inputTo(SEND_TO);
        messagesPage.inputSubject(SUBJECT);
        messagesPage.inputText(TEXT);
        messagesPage.clickSend();

        assertTrue(messagesPage.titleIs("Письмо отправлено - Почта Mail.Ru"));
    }

    @Test
    public void loginAndCreateMessageWithSteps() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getPage();
        AccountPage accountPage = loginPage.getSteps().login(USERNAME, DOMAIN, PASSWORD);
        MessagesPage messagesPage = accountPage.getMessagesPage();
        messagesPage.getSteps().createNewMessage(SEND_TO, SUBJECT, TEXT);

        assertTrue(messagesPage.titleIs("Письмо отправлено - Почта Mail.Ru"));
    }
}
