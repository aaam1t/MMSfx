package model;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Memberships {

    private ObservableList<Membership> Memberships;
    private ObservableList<Membership> current;

    public Memberships() {
        current = FXCollections.<Membership>observableArrayList();
        Memberships = FXCollections.observableArrayList(
         new Membership("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "13697480", 2134.5),
        new Membership("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "14517800", 4512.2),
        new Membership("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "13267102", 158.4),
        new Membership("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney 2100", "13678200", 7596.3),
        new Membership("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "13972870", 1100.0),
        new Membership("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "13859610", 6741.2)
        );
        current.addAll(Memberships);
        Memberships.addListener(new ListChangeListener<Membership>() {
            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Membership> c) {
                current.clear();
                current.addAll(Memberships);
            }
        });
    }

    public void addMembership(Membership Membership) {
        Memberships.add(Membership);
    }

    public void addMembership(String name, String email, String phone, String address, String ID, double expense) {
        Memberships.add(new Membership(name,email,phone,address,ID,expense));
    }
    
    public boolean hasMembership(String name) {
        for(Membership e:Memberships)
            if(e.hasName(name)&& !name.isEmpty())
                return true;
        return false;
    }
    
    public Membership getMembership(String name){
        for(Membership p: Memberships)
            if(p.hasName(name))
                return p;
        return null;                        
    }

    public void remove(Membership p) {
        this.Memberships.remove(p);
    }

    public void remove(List<Membership> selectedItems) {
        this.Memberships.removeAll(selectedItems);
    }

    public void addMemberships(List<Membership> selectedItems) {
        this.Memberships.addAll(selectedItems);
    }

    public ObservableList<Membership> getCurrentList() {
        return this.current;
    }

    public void filterList(String name, String email) {

        List<Membership> temp = new ArrayList<>();

        Memberships.forEach((Membership p) -> {
            try {
                if ((p.hasName(name)) || (p.hasEmail(email))) {
                    temp.add(p);
                }
            } catch (NumberFormatException e) {
            }
        });

        this.current.clear();
        this.current.addAll(temp);
    }
}
