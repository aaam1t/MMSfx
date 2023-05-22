package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class MMSreport {
    
    private StringProperty name;
    private StringProperty type;
    private DoubleProperty totalCredits;
    private DoubleProperty GasdeductionRate;
    private DoubleProperty DollarAvailable;
    private DoubleProperty deductionRate;
    private DoubleProperty PayPerCredit;
    private DoubleProperty expense;

    public MMSreport(Membership e) 
{
        this.name = new SimpleStringProperty();
        this.name.set(e.getName());
        this.type = new SimpleStringProperty();
        this.type.set(e.getType());
        this.totalCredits=new SimpleDoubleProperty();
        this.totalCredits.set(e.gettotalCredits());
        this.GasdeductionRate=new SimpleDoubleProperty();
        this.GasdeductionRate.set(e.getGasdeductionRate());
        this.DollarAvailable=new SimpleDoubleProperty();
        this.DollarAvailable.set(e.getDollarAvailable());
        this.deductionRate=new SimpleDoubleProperty();
        this.deductionRate.set(e.getdeductionRate());
        this.PayPerCredit=new SimpleDoubleProperty();
        this.PayPerCredit.set(e.getPayPerCredit());
        this.expense=new SimpleDoubleProperty();
        this.expense.set(e.getexpense());  
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }
    public ReadOnlyStringProperty typeProperty() {
        return type;
    }

    public String gettype() {
        return type.getValue();
    }

    public ReadOnlyDoubleProperty totalCreditsProperty() {
        return totalCredits;
    }

    public double gettotalCredits() {
        return totalCredits.get();
    }

    public ReadOnlyDoubleProperty GasdeductionRateProperty() {
        return GasdeductionRate;
    }

    public double getGasdeductionRate() {
        return GasdeductionRate.get();
    }

    public ReadOnlyDoubleProperty DollarAvailableProperty() {
        return DollarAvailable;
    }

    public double getDollarAvailable() {
        return DollarAvailable.get();
    }

    public ReadOnlyDoubleProperty deductionRateProperty() {
        return deductionRate;
    }

    public double getdeductionRate() {
        return deductionRate.get();
    }
    public ReadOnlyDoubleProperty PayPerCreditProperty() {
        return PayPerCredit;
    }

    public double getPayPerCredit() {
        return PayPerCredit.get();
    }
    public ReadOnlyDoubleProperty expenseProperty() {
        return expense;
    }

    public double getexpense() {
        return expense.get();
    }
}
