import com.epam.jdi.light.driver.get.DriverData;
import entities.MetalsAndColors;
import entities.User;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static enums.HeaderMenuItems.METALS_AND_COLORS;
import static org.testng.Assert.assertEquals;

public class Hw8 {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = ChoiceDataProvider.class)
    public void hw8(MetalsAndColors metalsAndColors) throws IOException { // TODO What is the reason of throws here ?
        //1.Login on JDI site as User
        JdiSite.open();
        JdiSite.homePage.login(User.PITER_CHAILOVSKII);
        JdiSite.homePage.checkLoggedin(User.PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        JdiSite.homePage.clickHeaderMenuOption(METALS_AND_COLORS.getItem());

        //3. Fill form Metals & Colors by data below
        JdiSite.metalsAndColorsPage.submitMetalsAndColorsForm(metalsAndColors);

        //4. Result sections should contains data below
        assertEquals(JdiSite.metalsAndColorsPage.getResults(),
                metalsAndColors.expectFormLog());

        // TODO It will be better to create specific method for 'log out'.
        JdiSite.homePage.getProfilePhoto().click();
        JdiSite.homePage.getLogout().click();
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}

