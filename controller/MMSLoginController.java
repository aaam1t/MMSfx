package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;
import model.SuperMarket;

public class MMSLoginController extends Controller<Session> {
    @FXML private Label errorLbl;
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button okBtn;
    @FXML private Button cancelBtn;

    private String getEmail() { return emailTf.getText(); }
    private String getPassword() { return passwordTf.getText(); }
    private void setBlank() { emailTf.setText(""); passwordTf.setText(""); }

    @FXML
    private void handleOk(ActionEvent event) throws Exception {
        String email = getEmail();
        String password = getPassword();
        setBlank();
        if (getSession().getSuperMarket(email, password) != null) {
            errorLbl.setVisible(false);
            SuperMarket s = getSession().getSuperMarket(email, password);
            String title = "Session Admin: " + s.getName();
            Stage superStage = new Stage();
            superStage.getIcons().add(new Image("view/SuperMarket.png"));
            superStage.centerOnScreen();
            stage.close();
            ViewLoader.showStage(s, "/view/SuperMarket.fxml", title, superStage);
        }
        else {
            errorLbl.setVisible(true);
        }
    }

    @FXML private void handleCancel(ActionEvent event) { stage.close(); }

    public Session getSession() { return model; }
}