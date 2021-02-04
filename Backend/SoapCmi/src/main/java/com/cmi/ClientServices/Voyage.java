package com.cmi.ClientServices;

import java.util.Date;

public class Voyage {
    long id;
    int nbrPersonne;
    Date voyageDate ;

    public Voyage(long id, int nbrPersonne, Date voyageDate) {
        this.id = id;
        this.nbrPersonne = nbrPersonne;
        this.voyageDate = voyageDate;
    }
}
