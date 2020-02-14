import com.epam.jdi.light.driver.get.DriverData;
import com.epam.jdi.tools.func.JAction1;
import entities.User;
import enums.HeaderMenuItems;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static entities.Defaults.TEST_METALS_AND_COLORS;
import static enums.HeaderMenuItems.METALS_AND_COLORS;
import static org.testng.Assert.assertEquals;

public class Hw7 {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = (cap ->
                cap.addArguments("--start-maximized"));
        initElements(JdiSite.class);
    }

    @Test
    public void hw7() {
        //1.Login on JDI site as User
        JdiSite.open();
        JdiSite.homePage.login(User.PITER_CHAILOVSKII);
        JdiSite.homePage.checkLoggedIn(User.PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        // TODO It will be better with ENUM, cause it helps us to avoid misspelling and so on.
        // TODO In this case, you should not pass the string to the method, pass enum itself !
        // The similar like JdiSite.homePage::login
        JdiSite.homePage.clickHeaderMenuOption(METALS_AND_COLORS);

        //3. Fill form Metals & Colors by data below
        JdiSite.metalsAndColorsPage.submitMetalsAndColorsForm(TEST_METALS_AND_COLORS);

        //4. Result sections should contains data  below
        assertEquals(JdiSite.metalsAndColorsPage.getResults(),
                TEST_METALS_AND_COLORS.expectFormLog());
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
