package com.cmi.ClientServices;

import java.util.Date;

public class TransportForm {

    public String[] arrivalStations;
    public String[] departureStations;
    public Date voyageDate ;
    public int number_peronne;

    public TransportForm(String[] arrivalStations, String[] departureStations, Date voyageDate, int number_peronne) {
        this.arrivalStations = arrivalStations;
        this.departureStations = departureStations;
        this.voyageDate = voyageDate;
        this.number_peronne = number_peronne;
    }

    public String[] getArrivalStations() {
        return arrivalStations;
    }

    public void setArrivalStations(String[] arrivalStations) {
        this.arrivalStations = arrivalStations;
    }

    public String[] getDepartureStations() {
        return departureStations;
    }

    public void setDepartureStations(String[] departureStations) {
        this.departureStations = departureStations;
    }

    public Date getVoyageDate() {
        return voyageDate;
    }

    public void setVoyageDate(Date voyageDate) {
        this.voyageDate = voyageDate;
    }

    public int getNumber_peronne() {
        return number_peronne;
    }

    public void setNumber_peronne(int number_peronne) {
        this.number_peronne = number_peronne;
    }
}
