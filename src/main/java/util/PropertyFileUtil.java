package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 *
 * @author abinav
 *This Utility will fetch the data from Properties file
 *
 */
public class PropertyFileUtil {

    private static final String PROPERTIES_PATH_FOLDER = "/configs/";

    static Properties propDetails = new Properties();
    InputStream input = null;
    InputStream output = null;

    public static String readFile(String fileName, String obName)
    {
        try {

            InputStream filePath =  PropertyFileUtil.class.getResourceAsStream(PROPERTIES_PATH_FOLDER+fileName);

            // load a properties file
            propDetails.load(filePath);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String ObValue = propDetails.getProperty(obName);
        return ObValue;
    }

}
