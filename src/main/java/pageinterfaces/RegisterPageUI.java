package pageinterfaces;

public abstract class RegisterPageUI {
    public static final String EMAIL_TEXTBOX = "css=input[name='emailid']";
    public static final String SUBMIT_BUTTON = "css=input[name='btnLogin']";
    public static final String USER_ID_ROW = "xpath=//td[@class='accpage' and contains(text(), 'User ID')]//following-sibling::td";
    public static final String PASSWORD_ROW = "xpath=//td[@class='accpage' and contains(text(), 'Password')]//following-sibling::td";
}
