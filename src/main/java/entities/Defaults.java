package entities;

import java.util.Arrays;

public class Defaults {
    public static MetalsAndColors TEST_METALS_AND_COLORS = new MetalsAndColors()
            .set(testDate -> {
                testDate.setSummary(Arrays.asList("3", "8"));
                testDate.setElements(Arrays.asList("Water", "Fire"));
                testDate.setColor("Red");
                testDate.setMetals("Selen");
                testDate.setVegetables(Arrays.asList("Cucumber", "Tomato"));
            });

    public static final int METAL_AND_COLORS_SUMMARY_DEFAULT = 3;

    public static final String JSON_DATA_FILE = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
}
