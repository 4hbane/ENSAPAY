package com.cmi;

import com.cmi.entities.Categorie;
import com.cmi.entities.Creance;
import com.cmi.entities.Creancier;
import com.cmi.repository.CreanceRepository;
import com.cmi.repository.CreancierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreancierRepository creancierRepository, CreanceRepository creanceRepository) {
        return args -> {

            Creancier radema= creancierRepository.save(new Creancier(1L,10000L,"Radema", Categorie.EauEtElectricite,null));
            Creancier iam = creancierRepository.save(new Creancier(2L,10001L,"IAM",Categorie.Telephonie,null));
            Creancier oncf= creancierRepository.save(new Creancier(3L,10002L,"ONCF",Categorie.Transport,null));

            creanceRepository.save(new Creance(1L,500L,"Facture Eau et Electricite",radema));
            creanceRepository.save( new Creance(2L,501L,"Facture téléphonique",iam));
            creanceRepository.save(new Creance(3L,502L,"Facture transport",oncf));
            creanceRepository.save( new Creance(4L,503L,"Recharge téléphonique",iam));

        };
    }

}
