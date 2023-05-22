package model;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class SuperMarket {
    private StringProperty name;
    private StringProperty email;
    private StringProperty password;
    private Memberships Memberships;


    public SuperMarket(String name, String email, String password) {
        this.name = new SimpleStringProperty();
        this.name.set(name);
        this.email = new SimpleStringProperty();
        this.email.set(email);
        this.password = new SimpleStringProperty();
        this.password.set(password);
        Memberships = new Memberships();
    }

    public SuperMarket() {
        this.Memberships = new Memberships();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ReadOnlyStringProperty emailProperty() {
        return email;
    }

    public String getEmail() {
        return email.getValue();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ReadOnlyStringProperty passwordProperty() {
        return password;
    }

    public String getPassword() {
        return password.getValue();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    public boolean login(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    
    public ObservableList<Membership> getMemberships(){
        return this.Memberships.getCurrentList();
    }
    
    public void addMembership(Membership e){
        this.Memberships.addMembership(e);
    }
    
    public boolean checkMembership(String name){
        return this.Memberships.hasMembership(name);
    }
    
    public void removeMembership(Membership e){
        this.Memberships.remove(e);
    }
    
    public void filterList(String name, String email) {
        this.Memberships.filterList(name, email);
    }
}
