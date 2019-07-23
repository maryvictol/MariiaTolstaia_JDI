package form;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.base.HtmlRadioGroup;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import entities.MetalsAndColors;
import lombok.Getter;

// TODO Pay attention of code formatting !
@Getter
public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @Css("#radio")
    private RadioButtons summary;

    @XPath("//p[@class='checkbox']")
    private HtmlRadioGroup elements;

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist color;

    @JDropdown(root = "div[id=metals]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "div[id=salad-dropdown",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist vegetables;

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
