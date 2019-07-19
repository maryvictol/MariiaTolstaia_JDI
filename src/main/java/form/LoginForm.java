package form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.common.TextField;
import entities.User;

public class LoginForm extends Form<User> {

    @Css("#name")
    private TextField login;

    @Css("#password")
    private TextField password;

    @Css("#login-button")
    private Button submit;

    @Css("#user-name")
    private Text fullUserName;

    @Override
    public void login(User user){
        login.input(user.getLogin());
        password.input(user.getPassword());
        submit.click();
    }

}
