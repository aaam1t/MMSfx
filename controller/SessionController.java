package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;

public class SessionController extends Controller<Session> {
    @FXML private Button loginBtn;
    @FXML private Button exitBtn;
    private Stage loginStage;

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        loginStage = new Stage();
        loginStage.getIcons().add(new Image("view/book.png"));
        loginStage.centerOnScreen();
        ViewLoader.showStage(getSession(), "/view/MMSlogin.fxml", "Sign In", loginStage);
    }

    @FXML private void handleExit(ActionEvent event) { Platform.exit(); }

    public Session getSession() { return model; }
}