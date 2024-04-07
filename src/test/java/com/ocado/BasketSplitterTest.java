package com.ocado;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class BasketSplitterTest {

    @Test
    public void splitTest() {
        try {
            Map<String, List<String>> expectedMap = new HashMap<>();

            expectedMap.put("Express Delivery", Arrays.asList("Steak (300g)", "Carrots (1kg)",
                    "Cold Beer (330ml)", "AA Battery (4 Pcs.)"));
            expectedMap.put("Courier", Arrays.asList("Espresso Machine", "Garden Chair"));

            BasketSplitter splitter =
                    new BasketSplitter(Path.of("config.json").toAbsolutePath().toString());
            Map<String, List<String>> map = splitter
                    .split(Arrays.asList("Steak (300g)", "Carrots (1kg)", "Cold Beer (330ml)",
                            "AA Battery (4 Pcs.)", "Espresso Machine", "Garden Chair"));
            assertEquals(map, expectedMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadFileTest() {
        String expectedResult =
                "{\n\"Carrots (1kg)\": [\"Express Delivery\", \"Click&Collect\"],\n\"Cold Beer (330ml)\": [\"Express Delivery\"],\n\"Steak (300g)\": [\"Express Delivery\", \"Click&Collect\"],\n\"AA Battery (4 Pcs.)\": [\"Express Delivery\", \"Courier\"],\n\"Espresso Machine\": [\"Courier\", \"Click&Collect\"],\n\"Garden Chair\": [\"Courier\"]\n}";
        try {
            String readFile =
                    IOUtils.readFileAsString(Path.of("config.json").toAbsolutePath().toString());
            assertEquals(readFile, expectedResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
