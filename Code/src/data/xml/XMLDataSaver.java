package data.xml;

import model.Interface.DataSaver;
import model.statistic.Resultat;
import model.statistic.SurrogateResultat;
import utils.DataPath;

import java.io.*;

public class XMLDataSaver implements DataSaver {

    public static void serialize(Object object) throws IOException {
        File repositoryPathToCreate = new File(DataPath.STATS_PATH_DOCUMENT + "\\DataJavSmash");
        File filePath = new File(repositoryPathToCreate.getPath() + "\\DataJavSmash.dat");

        try {
            if (repositoryPathToCreate.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(new SurrogateResultat((Resultat) object));
                objectOutputStream.close();
            } else {

                if (repositoryPathToCreate.mkdir()) {
                    System.out.println("File created");
                }
                serialize(object);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
