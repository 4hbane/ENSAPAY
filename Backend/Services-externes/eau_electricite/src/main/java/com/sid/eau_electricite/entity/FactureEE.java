package com.sid.eau_electricite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureEE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long numContrat;
    @NotNull
    private ContratType type;
    @NotNull
    private String nomClient;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @NotNull
    @Temporal (TemporalType.DATE)
    private Date periode;
    @NotNull
    @Temporal (TemporalType.DATE)
    private Date echeance;
    @NotNull
    private double montant;
    @NotNull
    private double frais;
    @NotNull
    private double penalite;
    @NotNull
    private boolean paid;
    @NotNull
    private String adresse;
    @NotNull
    private ImpayeType impayeType;

    public double changePenalite (){
        Date today = new Date();
        if(this.getEcheance().compareTo(today) < 0){
            long difference = today.getTime() - this.echeance.getTime();
            float daysBetween = (difference / (1000*60*60*24));
            this.setImpayeType(ImpayeType.Penalite);
            this.setPenalite(this.montant*1/100*daysBetween);
        }
        return this.penalite;
    }

}
