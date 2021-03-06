package pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import com.epam.jdi.light.ui.html.elements.common.Button;
import entities.User;
import enums.HeaderMenuItems;
import form.LoginForm;
import lombok.Getter;
import org.hamcrest.Matchers;

@Getter
public class HomePage extends WebPage {
    private LoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @Css("div[class=logout]")
    private Button logout;

    @Css("ul.m-l8 > li")
    private JList<UIElement> headerMenu;

    public void login(User user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void logout() {
        getProfilePhoto().click();
        getLogout().click();
    }

    public void checkLoggedIn(User user) {
        userName.shouldBe()
                .text(Matchers.equalTo(user.getFullUserName()));
    }

    public void clickHeaderMenuOption(HeaderMenuItems option) {
        headerMenu.select(option.getItem());
    }
}
