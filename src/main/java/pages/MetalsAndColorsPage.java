package pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import entities.MetalsAndColors;
import form.MetalsAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    @XPath("//ul[@class='panel-body-list results']//li")
    private WebList results;

    public void submitMetalsAndColorsForm(MetalsAndColors metalsAndColors){
        metalsAndColorsForm.submitMetalsAndColorsForm(metalsAndColors);
    }

    public List<String> getResults(){
        List<String> allResults = results.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
        return allResults;
    }
}
