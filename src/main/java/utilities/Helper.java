package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Helper {

    public static String getProperty(String propName) {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src//main//resources//testconfig-QA.properties"));
            return prop.getProperty(propName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
