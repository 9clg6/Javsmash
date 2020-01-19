package model.statistic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Statistic {

    private final StringProperty statistic = new SimpleStringProperty();
        public String getStatistic() {return statistic.get();}
        public StringProperty statisticProperty() {return statistic;}
        public void setStatistic(String statistic) {this.statistic.set(statistic);}


    public Statistic(String statistic) {
        this.statistic.set(statistic);

    }
}
