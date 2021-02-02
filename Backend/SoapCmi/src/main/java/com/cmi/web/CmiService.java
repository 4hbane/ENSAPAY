package com.cmi.web;

import com.cmi.ClientServices.Bill;
import com.cmi.ClientServices.ClientService;
import com.cmi.ClientServices.CompanyAccount;
import com.cmi.ClientServices.PersonalAccount;
import com.cmi.entities.Formulaire;
import com.cmi.entities.Categorie;
import com.cmi.entities.Creance;
import com.cmi.entities.Creancier;
import com.cmi.repository.CreanceRepository;
import com.cmi.repository.CreancierRepository;
import com.sid.eau_electricite.web.FactureEE;
import com.sid.eau_electricite.web.FactureEEService;
import com.sid.eau_electricite.web.FactureEEService_Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
@WebService(serviceName = "CmiService")
public class CmiService {
    @Autowired
    private CreancierRepository creancierRepository;
    @Autowired
    private CreanceRepository creanceRepository;
    @Autowired
    private  ClientService clientService;

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
    public FactureEE ConfirmePayerFactureEE(@WebParam(name = "factureId") Long id, @WebParam(name = "numTelef") String numTelef){
        FactureEE factureEE = factureEEService.getFacture(id);
        //TODO: import clientservice as feignClient
        //TODO: add those methods (getPersonalAccountNumberByPhoneNumber/getCompanyAccountNumberByName/getPersonalAccountByAccountNumber)
        //TODO: import Bill class
        //TODO: test this method
        double montantApayer = factureEE.getMontant()+factureEE.getFrais()+factureEE.getPenalite();
        PersonalAccount client = clientService.getPersonalAccountPhoneNumber ( numTelef ).get ();
        CompanyAccount company = clientService.getAccountByName ("RADEMA" ).get ();
        if (client.getBalance () < montantApayer){
            return factureEE;
        }
        Bill bill = new Bill(client.getAccountNumber (), company.getAccountNumber (), montantApayer);
        if(clientService.makePayment(bill)){
            factureEEService.payerFacture(id);
        }
        return factureEE;
    }

    //TODO: confirmerPayer pour service TELEPHONIE ( recharge / facture)


    //TODO: confirmerPayer pour service TRANSPORT

    @WebMethod
    public Double ConsulterSolde(@WebParam(name = "numCompte") String numCompte){
        //TODO: import clientservice as feignClient
        //TODO: add method (getPersonalAccountByAccountNumber)
        Optional<PersonalAccount> personalAccount = clientService.getPersonalAccountByAccountNumber (numCompte);
        if (personalAccount.isPresent ()){
            if (personalAccount.get ().getBalance () !=0 ) return personalAccount.get ().getBalance ();
        }
        return null;
    }

    @WebMethod
    public PersonalAccount getProfile(@WebParam(name = "phoneNumber") String phoneNumber){
        //TODO: import clientservice as feignClient
        //TODO: add method (getPersonalAccountByAccountNumber)
        Optional<PersonalAccount> personalAccount = clientService.getPersonalAccountPhoneNumber ( phoneNumber );
        if (personalAccount.isPresent ()){
            return personalAccount.get ();
        }
        return null;
    }



    @WebMethod
    public PersonalAccount createPersonalAccount(@WebParam(name = "firstName") String firstName,@WebParam(name = "lastName") String lastName, @WebParam(name = "phoneNumber") String phoneNumber, @WebParam(name = "email") String email,
                                                 @WebParam(name = "cin") String cin, @WebParam(name = "soldeInitial") Double soldeInitial){
        //TODO: import clientservice as feignClient
        //TODO: add method (getPersonalAccountByAccountNumber)
        PersonalAccount accountToCreate = new PersonalAccount (  firstName, lastName, cin, phoneNumber,email, soldeInitial );

        if (!clientService.verifyAccountExistence ( accountToCreate )){
            return clientService.saveNewPersonalAccount ( accountToCreate );
        }
        throw new RuntimeException("This has already an account !");
    }
}
