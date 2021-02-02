package com.sid.eau_electricite.web;

import com.sid.eau_electricite.entity.FactureEE;
import com.sid.eau_electricite.entity.ImpayeType;
import com.sid.eau_electricite.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


@Component
@WebService(serviceName = "FactureEEService")
public class FactureEEService {
    @Autowired
    private FactureRepository factureRepository;

    @WebMethod
    public List<FactureEE> getFactures(){
        return factureRepository.findAll();
    }

    @WebMethod
    public FactureEE getFacture(@WebParam (name = "id") Long id){
        return factureRepository.findById(id).get();
    }

    @WebMethod
    public List<FactureEE> getFacturesByNumContrat(@WebParam (name = "numContrat") Long numContrat){
        return factureRepository.getFacturesByNumContrat(numContrat);
    }

    @WebMethod
    public List<FactureEE> getFacturesImpayes(@WebParam (name = "numContrat") Long numContrat){
        return factureRepository.getFacturesByNumContratAndPaid(numContrat, false);
    }

    @WebMethod
    public FactureEE payerFacture (@WebParam (name = "id") Long id){
        if(factureRepository.findById(id).isPresent()) {
            FactureEE f = factureRepository.findById(id).get();
            f.setPaid(true);
            return factureRepository.save(f);
        }
        else return null;
    }

}
