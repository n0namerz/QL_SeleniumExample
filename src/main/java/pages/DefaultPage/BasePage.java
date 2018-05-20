package pages.DefaultPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Базовая страница в которой определен драйвер, ожидания, проверки на страницах,
 * остальные страницы наследуются от этого, чтобы на каждой странице отдельно не
 * объявляет эти вещи.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    /**
     * Ожидание появления нужного заголовка страницы.
     *
     * @param title Текст ожидаемого заголовка.
     * @return true - если мы дождались переданного тайтла, иначе false
     */
    public Boolean titleIs(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }
}
