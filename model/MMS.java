package model;

import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class MMS {
    private DoubleProperty totalCredits;
    private DoubleProperty GasdeductionRate;
    private DoubleProperty DollarAvailable;
    private DoubleProperty deductionRate;
    private DoubleProperty PayPerCredit;
//    private StringProperty type;
//    private StringProperty name;
    private DoubleProperty Expense;
    private ObservableList<Membership> memberships ;
    private ObservableList<MMSreport> reports;


    public MMS(SuperMarket SuperMarket)
    {
        this.memberships = SuperMarket.getMemberships();
        this.reports = FXCollections.<MMSreport>observableArrayList();   
        generateSLIP();
        this.totalCredits = new SimpleDoubleProperty();      
        this.totalCredits.set(getTotalCredits());
        this.GasdeductionRate = new SimpleDoubleProperty();      
        this.GasdeductionRate.set(getAvgGasdeductionRate());
        this.DollarAvailable = new SimpleDoubleProperty(); 
        this.DollarAvailable.set(getTotalDollarAvailable());
        this.deductionRate = new SimpleDoubleProperty(); 
        this.deductionRate.set(getAvgdeductionRate());
        this.PayPerCredit = new SimpleDoubleProperty(); 
        this.PayPerCredit.set(getAvgPayPerCredit());
        this.Expense = new SimpleDoubleProperty(); 
        this.Expense.set(getTotalExpense());
    }

//        this.bas = this.totalScholarship + this.totalDeduction;
    public void generateSLIP(){
        getMemberships().forEach(e -> {
            reports.add(new MMSreport(e));
        });
    }
    
//    public void setName(int id){
//        this.name=this.SuperMarket.getName()+String.valueOf(id);
//    }
    public ReadOnlyDoubleProperty totalCreditsProperty() {
        return totalCredits;
    } 
    public double getTotalCredits(){
        double total = 0;
        return getMemberships().stream().map(e -> e.gettotalCredits()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }


    public ReadOnlyDoubleProperty ExpenseProperty() {
        return Expense;
    } 
    public double getTotalExpense(){
        double total = 0;
        return getMemberships().stream().map(e -> e.getexpense()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }

    public ReadOnlyDoubleProperty GasdeductionRateProperty() {
        return GasdeductionRate;
    } 
    public double getAvgGasdeductionRate(){
        double total = 0;
        return (getMemberships().stream().map(e -> e.getGasdeductionRate()).reduce(total, (accumulator, _item) -> accumulator + _item)/getMemberships().size());
    }
    
    public ReadOnlyDoubleProperty DollarAvailableProperty() {
        return DollarAvailable;
    } 
    public double getTotalDollarAvailable(){
        double total = 0;
        return getMemberships().stream().map(e -> e.getDollarAvailable()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }

    public ReadOnlyDoubleProperty deductionRateProperty() {
        return deductionRate;
    } 
    public double getAvgdeductionRate(){
        double total = 0;
        return (getMemberships().stream().map(e -> e.getdeductionRate()).reduce(total, (accumulator, _item) -> accumulator + _item)/getMemberships().size());
    }

    public ReadOnlyDoubleProperty PayPerCreditProperty() {
        return deductionRate;
    } 
    public double getAvgPayPerCredit(){
        double total = 0;
        return (getMemberships().stream().map(e -> e.getPayPerCredit()).reduce(total, (accumulator, _item) -> accumulator + _item)/(double)getMemberships().size());
    }

    public ObservableList<Membership> getMemberships(){
        return this.memberships;
    }
    
    public ObservableList<MMSreport> reports(){
        return this.reports;
    }

}
