package com.sid.eau_electricite;

import com.sid.eau_electricite.entity.ContratType;
import com.sid.eau_electricite.entity.FactureEE;
import com.sid.eau_electricite.entity.ImpayeType;
import com.sid.eau_electricite.repository.FactureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class EauElectriciteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EauElectriciteApplication.class, args); }

    @Bean
    CommandLineRunner start(FactureRepository factureRepository) {
        return args -> {


            factureRepository.save(new FactureEE(1L,156842L, ContratType.ELECTRICITE,"OUTALEB Manal",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-14"),150.0,10.0,0.0,false,"hay baraka, Marrakech", ImpayeType.ImpayeSimple));

            factureRepository.save(new FactureEE(2L,156842L, ContratType.ELECTRICITE,"OUTALEB Manal",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-27"),160.0,10.0,0.0,true,"hay baraka, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(3L,156842L, ContratType.EAU,"OUTALEB Manal",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-20"),170.0,10.0,0.0,false,"hay baraka, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(4L,156842L, ContratType.ELECTRICITE,"OUTALEB Manal",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-29"),180.0,10.0,0.0,true,"hay baraka, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(5L,156842L, ContratType.EAU,"OUTALEB Manal",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-25"),10.0,10.0,0.0,false,"hay baraka, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(6L,156843L, ContratType.ELECTRICITE,"OUTALEB Mehdi",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-25"),196.0,10.0,0.0,false,"hay baraka2, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(7L,156844L, ContratType.ELECTRICITE,"OUTALEB Majd",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-25"),130.0,10.0,0.0,false,"hay baraka3, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(8L,156845L, ContratType.EAU,"AHBANE Abdou",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-25"),159.0,10.0,0.0,false,"hay baraka4, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(9L,156846L, ContratType.ELECTRICITE,"MNA Mounib",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-25"),423.0,10.0,0.0,false,"hay baraka5, Marrakech",ImpayeType.ImpayeSimple));
            factureRepository.save(new FactureEE(10L,156847L, ContratType.EAU,"KADDOURI Ghani",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-25"),50.0,10.0,0.0,false,"hay baraka6, Marrakech",ImpayeType.ImpayeSimple));

            FactureEE f = factureRepository.save(new FactureEE(11L,156847L, ContratType.EAU,"KADDOURI Ghani",new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"),new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-25"),50.0,10.0,0.0,false,"hay baraka6, Marrakech",ImpayeType.ImpayeSimple));
            f.changePenalite();
            factureRepository.save(f);

            factureRepository.findAll().forEach(c ->{
                FactureEE fac = c;
                fac.changePenalite();
                factureRepository.save(fac);
            });

        };
    }
}
