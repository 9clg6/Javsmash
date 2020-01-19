package view;

import Persistance.Stub;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.statistic.AllStats;
import model.statistic.Statistic;

import java.awt.event.ActionEvent;

public class StatisticController {

    @FXML
    private ListView<Statistic> laListe;

    private AllStats laPromotion;


    @FXML
    public void initialize() {
        laPromotion = Stub.chargerStatistic();

        laListe.itemsProperty().bind(laPromotion.lesEtudiantsProperty());

        laListe.setCellFactory(__ ->
                new ListCell<Statistic>() {
                    @Override
                    protected void updateItem(Statistic item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            textProperty().bind(item.statisticProperty());


                        } else {
                            textProperty().unbind();
                            setText("");
                        }
                    }
                }
        );
    }
}
