package form;

import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import entities.MetalsAndColors;
import lombok.Getter;

@Getter
public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @UI("//p[@class='radio']")
    private RadioButtons summary;
    ///label[.='7']

    @XPath("//p[@class='checkbox']")
    private RadioButtons elements;

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private DropdownExpand  color;

    @JDropdown(root = "div[id=metals]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private DropdownExpand  metals;

    @JDropdown(root = "div[id=salad-dropdown",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private DropdownExpand vegetables;

    @Css("#submit-button")
    private Button submit;

    public void submitMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColors.getSummary().forEach(element -> summary.select(element));
        metalsAndColors.getElements().forEach(element -> elements.select(element));
        color.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());
        vegetables.select("Vegetables");
        metalsAndColors.getVegetables().forEach(element -> vegetables.select(element));

        submit.click();
    }
}
