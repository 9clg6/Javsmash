package view;

import data.stub.StubDataLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import model.statistic.Resultat;
import model.statistic.Statistic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StatisticController{

    @FXML
    private TableView<Resultat> laListe = new TableView<>();

    private final TableColumn<Resultat, String> player1Column = new TableColumn<>("Joueur 1");
    private final TableColumn<Resultat, String> player2Column = new TableColumn<>("Joueur 2");
    private final TableColumn<Resultat, String> winnerColumn = new TableColumn<>("Gagnant");
    private final TableColumn<Resultat, String> dateColumn = new TableColumn<>("Date");

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private StringConverter<LocalDate> converter = new StringConverter<>() {
        @Override
        public LocalDate fromString(String string) {
            if (string == null || string.isEmpty()) {
                return null;
            } else {
                return LocalDate.parse(string, formatter);
            }
        }

        @Override
        public String toString(LocalDate date) {
            if (date == null) {
                return null;
            } else {
                return formatter.format(date);
            }
        }
    };


    @FXML
    public void initialize() {


        Statistic stats = StubDataLoader.chargerStatistic();

        laListe.itemsProperty().bind(stats.statisticProperty());


        player1Column.setCellValueFactory(new PropertyValueFactory<>("Joueur 1"));
        player1Column.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(res.getPlayer1());
        });

        player2Column.setCellValueFactory(new PropertyValueFactory<>("Joueur 2"));
        player2Column.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(res.getPlayer2());
        });

        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("Gagnant"));
        winnerColumn.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(res.getWinner());
        });

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        dateColumn.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(converter.toString(res.getDate()));
        });


        laListe.getColumns().setAll(player1Column, player2Column, winnerColumn, dateColumn);
    }


}

