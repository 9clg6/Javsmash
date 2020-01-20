package model.statistic;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Statistic {
    private ObservableList<Resultat> statisticObs = FXCollections.observableArrayList();
    private final ListProperty<Resultat> statistics = new SimpleListProperty<>(statisticObs);

    public ObservableList<Resultat> getStatistic() {
        return statistics.get();
    }

    public void setStatistic(ObservableList<Resultat> value) {
        statistics.set(value);
    }

    public ListProperty<Resultat> statisticProperty() {
        return statistics;
    }


    public void addStatistic(Resultat resultat) {
        statisticObs.add(resultat);
    }

}
