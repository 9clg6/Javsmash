package view;

import Persistance.Stub;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.statistic.Statistic;
import model.statistic.Resultat;

import java.awt.event.ActionEvent;

public class StatisticController {

    @FXML
    private TableView<Resultat> laListe = new TableView<>();

    private final TableColumn<Resultat, String> player1Column = new TableColumn<>("Joueur 1");
    private final TableColumn<Resultat, String> player2Column = new TableColumn<>("Joueur 2");
    private final TableColumn<Resultat, String> winnerColumn = new TableColumn<>("Gagnant");


    @FXML
    public void initialize() {


        Statistic stats = Stub.chargerStatistic();

        laListe.itemsProperty().bind(stats.statisticProperty());


        player1Column.setCellValueFactory(new PropertyValueFactory<>("Joueur 1"));
        player1Column.setCellValueFactory(param -> {
            final Resultat car = param.getValue();
            return new SimpleStringProperty(car.getPlayer2());
        });

        player2Column.setCellValueFactory(new PropertyValueFactory<>("Joueur 2"));
        player2Column.setCellValueFactory(param -> {
            final Resultat car = param.getValue();
            return new SimpleStringProperty(car.getPlayer2());
        });

        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("Gagant"));
        winnerColumn.setCellValueFactory(param -> {
            final Resultat car = param.getValue();
            return new SimpleStringProperty(car.getPlayer2());
        });


        laListe.getColumns().setAll(player1Column, player2Column, winnerColumn);
    }


}
