package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.networknt.schema.SchemaIdValidator;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Helper {

    public static String getProperty(String propName) {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src//main//resources//testconfig.properties"));
            return prop.getProperty(propName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
