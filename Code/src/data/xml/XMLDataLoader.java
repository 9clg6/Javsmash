package data.xml;

import model.Interface.DataLoader;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class XMLDataLoader implements DataLoader {

    public XMLDataLoader() {

    }

    public static Object loadResultat(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return object;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
