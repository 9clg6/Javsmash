package Persistance;

import model.statistic.AllStats;
import model.statistic.Statistic;

public class Stub {

    public static AllStats chargerStatistic(){
        AllStats stats = new AllStats();
        stats.addStatistic(new Statistic("Adrien63              Alain63             Adrien63"));
        stats.addStatistic(new Statistic("Mario37               Gamer27             Mario37"));

        return stats;
    }


}
