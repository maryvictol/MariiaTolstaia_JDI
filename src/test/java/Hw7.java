import com.epam.jdi.light.driver.get.DriverData;
import entities.User;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static entities.Defaults.TEST_METALS_AND_COLORS;
import static org.testng.Assert.assertEquals;

public class Hw7 {

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void hw7() {
        //1.Login on JDI site as User
        JdiSite.open();
        JdiSite.homePage.login(User.PITER_CHAILOVSKII);
        JdiSite.homePage.checkLoggedin(User.PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        // TODO It will be better with ENUM, cause it helps us to avoid misspelling and so on.
        JdiSite.homePage.clickHeaderMenuOption("METALS & COLORS");

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
