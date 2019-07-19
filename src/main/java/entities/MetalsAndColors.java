package entities;

import com.epam.jdi.tools.DataClass;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import static entities.Defaults.METAL_AND_COLORS_SUMMARY_DEFAULT;

@Getter
@Setter
public class MetalsAndColors extends DataClass<MetalsAndColors> {
    private List<String> summary;
    private List<String> elements;
    private String colors;
    private String metals;
    private List<String> vegetables;

    public List<String> expectFormLog(){
        List<String> expectLog = new ArrayList<>();
        int temp = METAL_AND_COLORS_SUMMARY_DEFAULT;

        if(getSummary() != null && !getSummary().isEmpty()) {
            temp = getSummary().stream().mapToInt(Integer::new).sum();
        }
        expectLog.add("Summary: " + temp);

        if(getElements() != null && !getElements().isEmpty()){
            expectLog.add("Elements: " + String.join(", ", getElements()));
        }

        if(getColors() != null && !getColors().isEmpty()){
            expectLog.add("Color: " + getColors());
        } else {
            expectLog.add("Color: Colors");
        }

        if ((getMetals() != null && !getMetals().isEmpty())) {
            expectLog.add("Metal: " + getMetals());
        } else {
            expectLog.add("Metal: Metals");
        }

        if(getVegetables() != null && !getVegetables().isEmpty()){
            expectLog.add("Vegetables: " + String.join(", ", getVegetables()));
        } else {
            expectLog.add("Vegetables:");
        }

        return expectLog;
    }

}
