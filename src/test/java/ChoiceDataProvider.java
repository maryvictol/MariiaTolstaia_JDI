import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.MetalsAndColors;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

import static entities.Defaults.JSON_DATA_FILE;

public class ChoiceDataProvider {
    @DataProvider(name = "dataProvider")
    public static Object[] dataProvider() throws IOException {
        return testDateFromJson(JSON_DATA_FILE).values().toArray();
    }

    private static Map<String, MetalsAndColors> testDateFromJson(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(new File(fileName).toPath(),
                StandardCharsets.UTF_8);
        Type itemsMapType = new TypeToken<Map<String, MetalsAndColors>>() {
        }.getType();
        return new Gson().fromJson(reader, itemsMapType);
    }
}

