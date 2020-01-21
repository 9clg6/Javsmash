package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import model.statistic.Resultat;
import model.statistic.Statistic;
import utils.alert.FileNullPopAlert;
import utils.alert.PopupError;

import java.awt.*;
import java.time.LocalDate;

public class AjoutResultatController {

    @FXML
    private TextField PlayerOneF = new TextField();
    @FXML
    private TextField PlayerTwoF = new TextField();
    @FXML
    private CheckBox PlayerOneCB = new CheckBox();
    @FXML
    private CheckBox PlayerTwoCB = new CheckBox();
    @FXML
    private Button addButton = new Button();
    @FXML
    private Button backButton = new Button();

    private Statistic stats;

    public AjoutResultatController(Statistic stats) {
        this.stats = stats;
    }


    @FXML
    private void initialize() {
        initializeButtons();
    }

    private void initializeButtons() {
        addButton.setOnAction(actionEvent -> {
            try {
                if (!PlayerOneF.getText().isEmpty() && !PlayerTwoF.getText().isEmpty()) {
                    if (PlayerOneCB.isSelected() && !PlayerTwoCB.isSelected()) {
                        addResultat(PlayerOneF.getText(), PlayerTwoF.getText(), PlayerOneF.getText());
                        close(actionEvent);
                    }
                    if (!PlayerOneCB.isSelected() && PlayerTwoCB.isSelected()) {
                        addResultat(PlayerOneF.getText(), PlayerTwoF.getText(), PlayerTwoF.getText());
                        close(actionEvent);
                    }
                }
            } catch (NullPointerException e) {
                new PopupError(new FileNullPopAlert("Two names are no selected"));
            }
        });
        backButton.setOnAction(this::close);

    }

    private void addResultat(String playerOne, String playerTwo, String winner) {
        Resultat resultat = new Resultat(playerOne, playerTwo, winner, LocalDate.now());
        stats.addStatistic(resultat);
    }

    private void close(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
