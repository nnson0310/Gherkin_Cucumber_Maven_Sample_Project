package pageinterfaces;

public abstract class CommonPageUI {

    public static final String DYNAMIC_MENU_SUB_LINK = "xpath=//ul[@class='menusubnav']/li/a[text()='%s']";
    public static final String DYNAMIC_FORM_TEXTBOX = "xpath=//table//input[@name='%s']";
    public static final String DYNAMIC_FORM_TEXTAREA = "xpath=//table//textarea[@name='%s']";
    public static final String DYNAMIC_FORM_RADIO = "xpath=//table//input[@type='radio' and @value='m']";
    public static final String DYNAMIC_FORM_BUTTON = "xpath=//table//input[@name='%s']";

}
