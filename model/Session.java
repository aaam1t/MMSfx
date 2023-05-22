package model;


public class Session 
{
    private SuperMarket SuperMarket;
    private SuperMarkets SuperMarkets;
    
    public Session(){
        this.SuperMarkets = new SuperMarkets(); 
        this.SuperMarket = new SuperMarket();
    }
 
    public SuperMarket getSuperMarket(String email, String password){
        return SuperMarkets.getSuperMarket(email, password);
    }
    
    public void setSuperMarket(SuperMarket e){
        this.SuperMarket = e;
    }
}

