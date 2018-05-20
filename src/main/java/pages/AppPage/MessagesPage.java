package pages.AppPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DefaultPage.BasePage;
import steps.OnMessagesPage;

/**
 * Раздел "Письма" на странице аккаунта.
 */
public class MessagesPage extends BasePage {
    private OnMessagesPage messagesPage;

    /**
     * Возвращает класс с шагами объединяющими действия на этой странице.
     *
     * @return класс с наборами шагов
     */
    public OnMessagesPage getSteps() {
        if (messagesPage == null) {
            messagesPage = new OnMessagesPage(driver);
        }
        return messagesPage;
    }

    public MessagesPage(WebDriver driver) {
        super(driver);

    }

    /**
     * Клик на кнопку создания нового сообщения.
     */
    public void clickNewMessage() {
        String aXpath = "//a[@title='Написать письмо (N)']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(aXpath))).click();
    }

    /**
     * Ввод адресата сообщения.
     *
     * @param to полный e-mail адресата
     */
    public void inputTo(String to) {
        String textareaXpath = "//textarea[@data-original-name='To']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textareaXpath))).sendKeys(to);
    }

    /**
     * Ввод темы сообщения.
     *
     * @param subject тема сообщения
     */
    public void inputSubject(String subject) {
        String inputXpath = "//input[@name='Subject']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputXpath))).sendKeys(subject);
    }

    /**
     * Ввод текста сообщения.
     *
     * @param text текст сообщения
     */
    public void inputText(String text) {
        String iframeXpath = "//div[@class='compose__editor']//iframe";
        String bodyXpath = "//body[@id='tinymce']";
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframeXpath)));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath(bodyXpath)).sendKeys(text);
        driver.switchTo().defaultContent();
    }

    /**
     * Клик на кнопку отправки сообщения.
     */
    public void clickSend() {
        String divXpath = "//div[@class='b-sticky']//div[@title='Отправить (Ctrl+Enter)']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(divXpath))).click();
    }
}
