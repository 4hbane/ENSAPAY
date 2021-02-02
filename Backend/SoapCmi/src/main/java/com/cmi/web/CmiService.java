package com.cmi.web;

import com.cmi.Formulaire;
import com.cmi.entities.Categorie;
import com.cmi.entities.Creance;
import com.cmi.entities.Creancier;
import com.cmi.repository.CreanceRepository;
import com.cmi.repository.CreancierRepository;
import com.sid.eau_electricite.web.FactureEE;
import com.sid.eau_electricite.web.FactureEEService;
import com.sid.eau_electricite.web.FactureEEService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;

@Component
@WebService(serviceName = "CmiService")
public class CmiService {
    @Autowired
    private CreancierRepository creancierRepository;
    @Autowired
    private CreanceRepository creanceRepository;

    private final FactureEEService factureEEService = new FactureEEService_Service().getFactureEEServicePort();


    @WebMethod
    public List<Creancier> listCreanciers() {
        return creancierRepository.findAll();
    }

    @WebMethod
    public List<Creance> listCreances() {
        return creanceRepository.findAll();
    }

    @WebMethod
    public Formulaire getForm (@WebParam(name = "codeCreance") Long codeCreance) {
        Creance creanceChoisi = creanceRepository.findCreanceByCodeCreance(codeCreance);
        Creancier creancierChoisi = creanceChoisi.getCreancier();
        Formulaire form = new Formulaire(creanceChoisi.getNomCreance(), creancierChoisi.getNomCreancier());
        if (creancierChoisi.getCategorie() == Categorie.EauEtElectricite) {
            HashMap<String, String> attributs = new HashMap<String, String>();
            attributs.put("Numéro de contrat","Long");
            form.setAttributs(attributs);
        } else if (creancierChoisi.getCategorie() == Categorie.Telephonie) {
            if(creanceChoisi.getNomCreance().equals("Facture téléphonique")){
                //facture
                HashMap<String, String> attributs = new HashMap<String, String>();
                attributs.put("Numéro de téléphone","Long");
                form.setAttributs(attributs);
            }else {
                //recharge
                HashMap<String, String> attributs = new HashMap<String, String>();
                attributs.put("Numéro de téléphone","Long");
                attributs.put("Numéro de contrat","Long");
                form.setAttributs(attributs);
            }
        }else{
           // TODO: Pour Transport
            //ajouter les attributs à afficher
        }
        return form;
    }

    //getImpayes pour service Facture EAU & ELECTRICITE
    @WebMethod
    public List<FactureEE> getImpayesEE(@WebParam(name = "numContrat") Long numContrat) {
        return factureEEService.getFacturesImpayes(numContrat);
    }

    //TODO: getImpayes pour service TELEPHONIE ( recharge / facture)


    //TODO: getImpayes pour service TRANSPORT

    @WebMethod
    public FactureEE ConfirmePayerFactureEE(@WebParam(name = "factureId") Long id, @WebParam(name = "numTelef") Long numTelef){
        FactureEE factureEE = factureEEService.getFacture(id);
        //TODO: import clientservice as feignClient
        //TODO: add those methods (getPersonalAccountNumberByPhoneNumber/getCompanyAccountNumberByName/getPersonalAccountByAccountNumber)
        //TODO: import Bill class
        //TODO: test this method
        double montantApayer = factureEE.getMontant()+factureEE.getFrais()+factureEE.getPenalite();
       /* String numCompteAdebiter = clientService.getPersonalAccountNumberByPhoneNumber(numTelef);
         String numCompteSociete = clientService.getCompanyAccountNumberByName("RADEMA");
        double solde = clientService.getPersonalAccountByAccountNumber(accountNumber).getBalance();
        if(solde < montantApayer){
            return factureEE;
        }else {
            Bill bill = new Bill(numCompteAdebiter, numCompteSociete, montantApayer);
            clientService.makePayment(bill);*/
            factureEEService.payerFacture(id);
            return factureEE;
        // }
    }

    //TODO: confirmerPayer pour service TELEPHONIE ( recharge / facture)


    //TODO: confirmerPayer pour service TRANSPORT

    @WebMethod
    public Double ConsulterSolde(@WebParam(name = "numCompte") String numCompte){
        //TODO: import clientservice as feignClient
        //TODO: add method (getPersonalAccountByAccountNumber)
      /*  PersonalAccount acc = clientService.getPersonalAccountByAccountNumber(numCompte);
        Double solde = acc.getBalance();
        if(solde != 0) return acc.getBalance();
        else*/ return null;
    }

    //TODO: création d’un compte de paiement
}
