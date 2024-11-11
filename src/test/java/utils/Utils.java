package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Utils {

    public static JSONArray readJSONFile() throws IOException, ParseException {
        String filePath = "src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        JSONArray userArr = (JSONArray) jsonParser.parse(new FileReader(filePath));

        return userArr;
    }
}
