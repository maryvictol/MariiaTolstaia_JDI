package pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import entities.User;
import form.LoginForm;
import org.hamcrest.Matchers;

public class HomePage extends WebPage {

    private LoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @Css("ul.m-l8 > li")
    private JList<HtmlElement> headerMenu;

    public void login(User user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void checkLoggedin(User user) {
        userName.shouldBe()
                .text(Matchers.equalTo(user.getFullUserName()));
    }

    public void clickHeaderMenuOption(String option){
        headerMenu.select(option);
    }
}
