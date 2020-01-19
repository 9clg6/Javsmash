package model.statistic;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllStats {
    private ObservableList<Statistic> allStatsObs = FXCollections.observableArrayList();
    private final ListProperty<Statistic> allStats = new SimpleListProperty<>(allStatsObs);
    public ObservableList<Statistic> getLesEtudiants() {return allStats.get();}
    public void setLesEtudiants(ObservableList<Statistic> value) {allStats.set(value);}
    public ListProperty<Statistic> lesEtudiantsProperty() {return allStats;}

    public void addStatistic(Statistic statistic) {
        allStatsObs.add(statistic);
    }

}
