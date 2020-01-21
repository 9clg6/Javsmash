package view;

import data.stub.StubDataLoader;
import data.xml.XMLDataLoader;
import data.xml.XMLDataSaver;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.statistic.Resultat;
import model.statistic.Statistic;
import model.statistic.SurrogateResultat;
import utils.alert.FileNullPopAlert;
import utils.alert.PopupError;
import utils.persistence.DataPath;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    @FXML
    private Button addButton = new Button();
    @FXML
    private Button deleteButton = new Button();

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

        addButton.setOnAction(actionEvent -> {
            try {
                Stage primaryStage = new Stage();
                primaryStage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AjoutResultat.fxml"));

                loader.setController(new AjoutResultatController(stats));

                Pane root = loader.load();

                Scene selectionScene = new Scene(root, 400, 400);
                primaryStage.setTitle("Ajout résultat");

                primaryStage.setScene(selectionScene);
                primaryStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        deleteButton.setOnAction(actionEvent -> {
            try {
                Resultat res = laListe.getSelectionModel().getSelectedItem();
                stats.removeResultat(res);
            } catch (NullPointerException e) {
                new PopupError(new FileNullPopAlert("No Resultat Selected"));
            }
        });
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


}

