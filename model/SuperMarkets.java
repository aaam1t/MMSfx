package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SuperMarkets {
    private final ObservableList<SuperMarket> SuperMarkets;

    public SuperMarkets() {
        SuperMarkets = FXCollections.observableArrayList(
                new SuperMarket("John Smith", "john.smith@uts.com", "user222"),
                new SuperMarket("Jane Tyler", "jane.tyler@uts.com", "super123"),
                new SuperMarket("Chao Yang", "t", "t")
        );      
    }
   
    public boolean hasSuperMarket(String name, String password) {
        return SuperMarkets.stream().anyMatch(p -> (p.login(name, password)));
    }

    public SuperMarket getSuperMarket(String name, String password){
        for(SuperMarket e:SuperMarkets)
            if(e.login(name, password))
                return e;
        return null;
    }   
}


