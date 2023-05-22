package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.MMS;
import model.MMSreport;
import model.Membership;
import model.SuperMarket;

public class SuperMarketController extends Controller<SuperMarket> {
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TableView<Membership> membershipsTv;
    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    @FXML private Button reportBtn;
    @FXML private Button closeBtn;

    @FXML
    private void initialize() {
        membershipsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        membershipsTv.getSelectionModel().selectedItemProperty().addListener((observable, oldMembership, newMembership) -> disableBtn(newMembership == null));
        nameTf.focusedProperty().addListener((observable, oldFocus, newFocus) -> filterList());
        emailTf.focusedProperty().addListener((observable, oldFocus, newFocus) -> filterList());
        nameTf.textProperty().addListener((observable, oldText, newText) -> filterList());
        emailTf.textProperty().addListener((observable, oldText, newText) -> filterList());
        deleteBtn.setDisable(true);
        selectBtn.setDisable(true);
        slipBtn.setDisable(true);
    }

    private void disableBtn(boolean notValid) {
        if (notValid) {
            deleteBtn.setDisable(true);
            selectBtn.setDisable(true);
            slipBtn.setDisable(true);
        }
        else {
            deleteBtn.setDisable(false);
            selectBtn.setDisable(false);
            slipBtn.setDisable(false);
        }
    }

    private Membership getSelectedMembership() { return membershipsTv.getSelectionModel().getSelectedItem(); }

    private String getName() { return nameTf.getText(); }
    private String getEmail() { return emailTf.getText(); }

    private void filterList() {
        if (nameTf.isFocused()) { getSupermarket().filterList(getName(), "#####"); }
        else if (emailTf.isFocused()) { getSupermarket().filterList("#####", getEmail()); }
    }

    @FXML
    private void handleAdd(ActionEvent event) throws Exception {
        Membership m = new Membership("", "", "", "", "", 0.0);
        m.setSuperMarket(getSupermarket());
        Stage addStage = new Stage();
        addStage.getIcons().add(new Image("view/edit.png"));
        addStage.centerOnScreen();
        ViewLoader.showStage(m, "/view/Membership.fxml", "Adding New Membership", addStage);
    }

    @FXML private void handleDelete(ActionEvent event) { getSupermarket().removeMembership(getSelectedMembership()); }

    @FXML
    private void handleSelect(ActionEvent event) throws Exception {
        Stage selectStage = new Stage();
        selectStage.getIcons().add(new Image("view/edit.png"));
        selectStage.centerOnScreen();
        ViewLoader.showStage(getSelectedMembership(), "/view/Membership.fxml", "Accessing File: " + getSelectedMembership().getName(), selectStage);
    }

    @FXML
    private void handleSlip(ActionEvent event) throws Exception {
        MMSreport r = new MMSreport(getSelectedMembership());
        Stage slipStage = new Stage();
        slipStage.getIcons().add(new Image("view/edit.png"));
        slipStage.centerOnScreen();
        ViewLoader.showStage(r, "/view/slip.fxml", getSelectedMembership().getName() + " SLIP Report", slipStage);
    }
    
    @FXML private void handleReport(ActionEvent event) throws Exception {
        MMS m = new MMS(getSupermarket());
        Stage mmsStage = new Stage();
        mmsStage.getIcons().add(new Image("view/uts.jpeg"));
        mmsStage.centerOnScreen();
        ViewLoader.showStage(m, "/view/mms.fxml", "MMS Report", mmsStage);
    }

    @FXML private void handleClose(ActionEvent event) { stage.close(); }

    public SuperMarket getSupermarket() { return model; }
}