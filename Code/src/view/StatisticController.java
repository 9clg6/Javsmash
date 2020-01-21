package view;

import data.stub.StubDataLoader;
import data.xml.XMLDataLoader;
import data.xml.XMLDataSaver;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.statistic.Resultat;
import model.statistic.Statistic;
import model.statistic.SurrogateResultat;
import utils.DataPath;
import utils.FileNullPopAlert;
import utils.PopupError;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StatisticController {

    private final TableColumn<Resultat, String> player1Column = new TableColumn<>("Player 1");
    private final TableColumn<Resultat, String> player2Column = new TableColumn<>("Player 2");
    private final TableColumn<Resultat, String> winnerColumn = new TableColumn<>("Winner");
    private final TableColumn<Resultat, String> dateColumn = new TableColumn<>("Date");

    @FXML
    private TableView<Resultat> laListe = new TableView<>();
    @FXML
    private Button LoadButton = new Button();
    @FXML
    private Button SaverButton = new Button();
    @FXML
    private Button clearButton = new Button();

    private Statistic stats = StubDataLoader.loadResultat();

    private File selectedFile;

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

        laListe.itemsProperty().bind(stats.statisticProperty());

        initializeButtons();
        initializeCells();
    }

    private FileChooser initializeFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll();

        fileChooser.setInitialDirectory(new File(DataPath.STATS_PATH_DOCUMENT));

        return fileChooser;
    }


    private void initializeButtons() {
        LoadButton.setOnAction(actionEvent ->
        {
            try {
                selectedFile = initializeFileChooser().showOpenDialog(new Stage());

                SurrogateResultat surrogateResultat = (SurrogateResultat) XMLDataLoader.loadResultat(selectedFile.getPath());

                stats.addStatistic(new Resultat(surrogateResultat.getPlayerOne(), surrogateResultat.getPlayerTwo(), surrogateResultat.getWinner(), surrogateResultat.getLocalDate()));


                initializeCells();

            } catch (NullPointerException e) {
                new PopupError(new FileNullPopAlert("Zero File Selected"));
            }
        });

        SaverButton.setOnAction(actionEvent -> {
            try {
                for (Resultat resultat : laListe.getItems()) {
                    XMLDataSaver.serialize(resultat);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        clearButton.setOnAction(actionEvent -> clearCells());
    }

    private void initializeCells() {

        player1Column.setCellValueFactory(new PropertyValueFactory<>("Player 1"));
        player1Column.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(res.getPlayer1());
        });

        player2Column.setCellValueFactory(new PropertyValueFactory<>("Player 2"));
        player2Column.setCellValueFactory(param -> {
            final Resultat res = param.getValue();
            return new SimpleStringProperty(res.getPlayer2());
        });

        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("Winner"));
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

    private void clearCells() {
        laListe.getItems().clear();
    }

    private ArrayList<Resultat> conversionSurrogateResultatToResultat(ArrayList<SurrogateResultat> listSurrogateResultat) {
        ArrayList<Resultat> listResultat = new ArrayList<>();
        for (SurrogateResultat surrogateResultat : listSurrogateResultat) {
            listResultat.add(new Resultat(surrogateResultat.getPlayerOne(), surrogateResultat.getPlayerTwo(), surrogateResultat.getWinner(), surrogateResultat.getLocalDate()));

        }

        return listResultat;
    }

}

