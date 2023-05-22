package model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Membership {
    private StringProperty ID;
    private StringProperty name;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty address;
    private StringProperty type;
    private DoubleProperty expense;
    private DoubleProperty payPerCredit;
    private DoubleProperty totalCredits;
    private DoubleProperty GasdeductionRate;
    private IntegerProperty DollarAvailable;
//    private DoubleProperty DollarAvailable;
    private DoubleProperty deductionRate;
    private SuperMarket  SuperMarket;

    public Membership(String name, String email, String phone, String address, String ID,  double expense) 
{
        this.name = new SimpleStringProperty();
        this.name.set(name);
        this.email = new SimpleStringProperty();
        this.email.set(email);
        this.phone = new SimpleStringProperty();
        this.phone.set(phone);
        this.address = new SimpleStringProperty();
        this.address.set(address);
        this.ID = new SimpleStringProperty();
        this.ID.set(ID);
        this.expense = new SimpleDoubleProperty();
        this.expense.set(expense);   
        SetType();
        setPayPerCredit();
        this.totalCredits = new SimpleDoubleProperty();
        this.totalCredits.bind(this.expense.multiply(this.payPerCredit));
        this.DollarAvailable = new SimpleIntegerProperty();
        this.DollarAvailable.bind(this.totalCredits.divide(200));
        SetdeductionRate();
        SetGasdeductionRate();
    }

    public void SetType()
    {
        this.type = new SimpleStringProperty();
        if (getexpense()>=500 && getexpense()<1500)
        {
            this.type.set("Silver");
        }
        else if (getexpense()>=1500 && getexpense()<3000)
        {
           this.type.set("Gold");
        }
        else if (getexpense()>=3000 && getexpense()<5000)
        {
            this.type.set("Diamond");
        }
        else if (getexpense()>=5000)
        {
            this.type.set("Platinum");
        }
        else if (getexpense()==0)
        {
            this.type.set("None");
        }
        else
        {
            this.type.set("Bronze");
        }
    }
    public void setPayPerCredit()
    {
        this.payPerCredit = new SimpleDoubleProperty();
        switch(getType()){
            case "Bronze":
                this.payPerCredit.set(20.00);
                break;
            case "Silver":
                this.payPerCredit.set(10.00);
                break;
            case "Gold":
                this.payPerCredit.set(8.00);
                break;
            case "Diamond":
                this.payPerCredit.set(6.00);
                break;
            case "Platinum":
                this.payPerCredit.set(4.00);
                break;
            default :
                this.payPerCredit.set(30.00);
                break;
        }
    }
    public void SetdeductionRate()
    {
        this.deductionRate = new SimpleDoubleProperty();
        switch(getType()){
            case "Bronze":
                this.deductionRate.set(0.05);
                break;
            case "Silver":
                this.deductionRate.set(0.10);
                break;
            case "Gold":
                this.deductionRate.set(0.15);
                break;
            case "Diamond":
                this.deductionRate.set(0.20);
                break;
            case "Platinum":
                this.deductionRate.set(0.25);
                break;
        }
    }
    public void SetGasdeductionRate()
    {
        this.GasdeductionRate = new SimpleDoubleProperty();
        switch(getType()){
            case "Bronze":
                this.GasdeductionRate.set(0.10);
                break;
            case "Silver":
                this.GasdeductionRate.set(0.15);
                break;
            case "Gold":
                this.GasdeductionRate.set(0.20);
                break;
            case "Diamond":
                this.GasdeductionRate.set(0.25);
                break;
            case "Platinum":
                this.GasdeductionRate.set(0.30);
                break;
        }
    }
    public void updateDetails(String name, String email, String phone, String address, String ID,  double expense){
        this.name.set(name);    
        this.email.set(email);        
        this.phone.set(phone);     
        this.address.set(address);        
        this.ID.set(ID); 
        this.expense.set(this.expense.getValue()+expense);     
        SetType();
        setPayPerCredit();
        this.totalCredits.bind(this.expense.multiply(this.payPerCredit));
        this.DollarAvailable.bind(this.totalCredits.divide(200));
        SetdeductionRate();
        SetGasdeductionRate();

    }


    public void setSuperMarket(SuperMarket e){
        this.SuperMarket = e;
    }

    public SuperMarket getSuperMarket(){
        return this.SuperMarket;
    }
    public ReadOnlyStringProperty nameProperty() 
    {
        return name;
    }
    public String getName(){
        return name.getValue();
    }
    public ReadOnlyStringProperty emailProperty() {
        return email;
    }

    public String getEmail(){
        return email.getValue();
    }

    public ReadOnlyStringProperty phoneProperty() {
        return phone;
    }

    public String getPhone(){
        return phone.getValue();
    }
    
    public ReadOnlyStringProperty addressProperty() {
        return address;
    }

    public String getAddress(){
        return address.getValue();
    }
    
    public ReadOnlyStringProperty IDProperty() {
        return ID;
    }

    public String getID(){
        return ID.getValue();
    }

   public ReadOnlyStringProperty typeProperty() {
        return type;
    }

    public String getType(){
        return type.getValue();
    }
    public ReadOnlyDoubleProperty payPerCreditProperty() 
    {
        return payPerCredit;
    }    
    
    public double getPayPerCredit(){
        return payPerCredit.get();
    }
    public ReadOnlyDoubleProperty totalCreditsProperty() 
    {
        return totalCredits;
    }    
    
    public double gettotalCredits(){
        return totalCredits.get();
    }
    public IntegerProperty DollarAvailableProperty() 
    {
        return DollarAvailable;
    }
    
    public double getDollarAvailable(){
        return DollarAvailable.get();
    }

    public ReadOnlyDoubleProperty GasdeductionRateProperty() 
    {
        return GasdeductionRate;
    }    
    
    public double getGasdeductionRate()
    {
        return GasdeductionRate.get();
    }


//    public ReadOnlyDoubleProperty payPerCreditProperty() 
//    {
//        return payPerCredit;
//    }    
//    
//    public double getPayPerCredit()
//    {
//        return payPerCredit.get();
//    }

    public ReadOnlyDoubleProperty deductionRateProperty() 
    {
        return deductionRate;
    }    
    public double getdeductionRate()
    {
        return deductionRate.get();
    }
    public ReadOnlyDoubleProperty expenseProperty() 
    {
        return expense;
    }    
    public double getexpense()
    {
        return expense.get();
    }


    public boolean hasName(String name){
        return getName().toLowerCase().contains(name.toLowerCase().trim());
    }

    public boolean hasEmail(String email){
        return getEmail().toLowerCase().contains(email.toLowerCase().trim());
    }

}



