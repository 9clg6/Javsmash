package utils;

import model.statistic.Resultat;

public class FileNameCreator {
    private static String uniqueName = null;


    public static String resultatFileName(Object object) {
        if (object instanceof Resultat) {
            uniqueName = ((Resultat) object).getWinner() + ((Resultat) object).getDate();
        }
        return uniqueName;
    }
}
