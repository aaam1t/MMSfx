package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.MMSreport;

public class MMSlipController extends Controller<MMSreport> {
    @FXML private Label creditLbl;
    @FXML private Label expenseLbl;
    @FXML private Label gasLbl;
    @FXML private Label payLbl;
    @FXML private Label dollarLbl;
    @FXML private Label deductionLbl;
    @FXML private Button closeBtn;

    @FXML
    private void initialize() {
        creditLbl.textProperty().bind(getMMSreport().totalCreditsProperty().asString("%.2f"));
        expenseLbl.textProperty().bind(getMMSreport().expenseProperty().asString("$%.2f"));
        gasLbl.textProperty().bind(getMMSreport().GasdeductionRateProperty().asString("%.2f"));
        payLbl.textProperty().bind(getMMSreport().PayPerCreditProperty().asString("%.2f"));
        dollarLbl.textProperty().bind(getMMSreport().DollarAvailableProperty().asString("$%.2f"));
        deductionLbl.textProperty().bind(getMMSreport().deductionRateProperty().asString("%.2f"));
    }

    @FXML private void handleClose(ActionEvent event) { stage.close(); }

    @FXML public MMSreport getMMSreport() { return model; }
}