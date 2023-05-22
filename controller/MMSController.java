package controller;

import java.util.ArrayList;
import java.util.Arrays;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.MMS;
import model.MMSreport;

public class MMSController extends Controller<MMS> {
    @FXML private Label expenseLbl;
    @FXML private Label gasLbl;
    @FXML private Label payLbl;
    @FXML private Label creditLbl;
    @FXML private Label deductionLbl;
    @FXML private Label dollarLbl;

    @FXML private TableView<MMSreport> membershipsTv;
    @FXML private TableColumn<MMSreport, Double> expenseColn;
    @FXML private TableColumn<MMSreport, Double> creditColn;
    @FXML private TableColumn<MMSreport, Double> gasColn;
    @FXML private TableColumn<MMSreport, Double> deductionColn;
    @FXML private TableColumn<MMSreport, Double> payColn;
    @FXML private TableColumn<MMSreport, Double> dollarColn;

    private ArrayList<TableColumn<MMSreport, Double>> colns;
    private ArrayList<TableColumn<MMSreport, Double>> dollarColns;
    
    @FXML private void initialize() {
        membershipsTv.setItems(getMMS().reports());
        membershipsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colns = new ArrayList<TableColumn<MMSreport, Double>>();
        dollarColns = new ArrayList<TableColumn<MMSreport, Double>>();

        colns.addAll(Arrays.asList(creditColn, gasColn, deductionColn, payColn));
        dollarColns.addAll(Arrays.asList(expenseColn, dollarColn));

        for (TableColumn<MMSreport, Double> coln : colns) {
            coln.setCellFactory(cell -> new TableCell<MMSreport, Double>() {
                @Override
                protected void updateItem(Double value, boolean empty) {
                    super.updateItem(value, empty);
                    if (value == null || empty) { setText(null); }
                    else { setText(String.format("%.2f", value.doubleValue())); }
                }
            });
        }

        for (TableColumn<MMSreport, Double> coln : dollarColns) {
            coln.setCellFactory(cell -> new TableCell<MMSreport, Double>() {
                @Override
                protected void updateItem(Double value, boolean empty) {
                    super.updateItem(value, empty);
                    if (value == null || empty) { setText(null); }
                    else { setText(String.format("$%.2f", value.doubleValue())); }
                }
            });
        }

        expenseLbl.textProperty().bind(getMMS().ExpenseProperty().asString("$%.2f"));
        gasLbl.textProperty().bind(getMMS().GasdeductionRateProperty().asString("%.2f"));
        payLbl.setText(String.format("%.2f", getMMS().getAvgPayPerCredit()));
        creditLbl.textProperty().bind(getMMS().totalCreditsProperty().asString("%.2f"));
        deductionLbl.textProperty().bind(getMMS().deductionRateProperty().asString("%.2f"));
        dollarLbl.textProperty().bind(getMMS().DollarAvailableProperty().asString("$%.2f"));
    }

    @FXML private void handleClose(ActionEvent event) { stage.close(); }

    @FXML public MMS getMMS() { return model; }
}