package varEnums;

/**
 * Перечисления с доменными именами, доступными на странице логина.
 */
public enum MailDomains {
    MAILRU("@mail.ru"),
    INBOXRU("@inbox.ru"),
    GMAILCOM("@gmail.com");

    private String domain;

    MailDomains(String domain) {
        this.domain = domain;

    }

    /**
     * Возвращает текст доменного имени.
     *
     * @return текст доменного имени.
     */
    public String getDomain() {
        return domain;

    }

}
