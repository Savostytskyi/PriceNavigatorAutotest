package core.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Anton_Savostytskyi on 02.06.2015.
 */
public class PropertyReader {


        public static final String TEST_PROPERTY_FILE = "pn.properties";

        public static Properties getInstance() {
            Properties properties = new Properties();
            InputStream is;
            try {
                is = new FileInputStream(TEST_PROPERTY_FILE );
                properties.load(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return properties;
        }
    }
