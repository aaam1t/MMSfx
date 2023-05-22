package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.InputException;
import model.Membership;

public class MembershipController extends Controller<Membership> {
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField idTf;
    @FXML private TextField expenseTf;
    @FXML private Text typeTxt;
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    @FXML private Button closeBtn;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String id;
    private double expense;

    private Validator v = new Validator();

    @FXML
    private void initialize() {
        nameTf.setText(getMembership().getName());
        emailTf.setText(getMembership().getEmail());
        phoneTf.setText(getMembership().getPhone());
        addressTf.setText(getMembership().getAddress());
        idTf.setText(getMembership().getID());
        expenseTf.setText("" + getMembership().getexpense());
        typeTxt.setText(getMembership().getType());
        
        addBtn.setDisable(!getMembership().getName().equals(""));
        updateBtn.setDisable(getMembership().getName().equals(""));
    }

    @FXML private void handleAdd(ActionEvent event) throws Exception {
        getInput();
        if (validate(name, email, phone, address, id, expense)) {
            getMembership().updateDetails(name, email, phone, address, id, expense);
            getMembership().getSuperMarket().addMembership(getMembership());
            handleClose(event);
        }
        else {
            showErrors(getErrorString(name, email, phone, address, id, expense));
        }
    }

    @FXML private void handleUpdate(ActionEvent event) throws Exception {
        getInput();
        if (validate(name, email, phone, address, id, expense)) {
            getMembership().updateDetails(name, email, phone, address, id, expense);
            handleClose(event);
        }
        else {
            showErrors(getErrorString(name, email, phone, address, id, expense));
        }
    }

    private void getInput() {
        name = nameTf.getText();
        email = emailTf.getText();
        phone = phoneTf.getText();
        address = addressTf.getText();
        id = idTf.getText();
        try { expense = Double.parseDouble(expenseTf.getText()); }
        catch (NumberFormatException e) { expense = -1.0; }
    }

    @FXML private void handleClose(ActionEvent event) { stage.close(); }

    private void showErrors(String message) throws Exception {
        Stage errorStage = new Stage();
        errorStage.getIcons().add(new Image("view/error.png"));
        errorStage.centerOnScreen();
        ViewLoader.showStage(new InputException(message), "/view/error.fxml", "Input Exceptions", errorStage);
    }

    private boolean validate(String name, String email, String phone, String address, String ID,  double expense) { return v.isValid(name, email, phone, address, ID, expense); }
    private String getErrorString (String name, String email, String phone, String address, String ID,  double expense) {
        String out = "";
        v.clear();
        v.generateErrors(name, email, phone, address, ID, expense);
        for (String error : v.errors()) {
            out += error;
        }
        return out;
    }

    public Membership getMembership() { return model; }
}