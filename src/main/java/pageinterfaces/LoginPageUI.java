package pageinterfaces;

public abstract class LoginPageUI {
    public static final String REGISTER_LINK = "xpath=//h4[@class='barone']//following-sibling::div//a[text()='here']";
    public static final String USER_ID_TEXTBOX = "css=input[name='uid']";
    public static final String PASSWORD_TEXTBOX = "css=input[name='password']";
    public static final String LOGIN_BUTTON = "css=input[name='btnLogin']";
}
