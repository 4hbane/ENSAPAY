package com.ENSAPAY.Clientservice;

import com.ENSAPAY.Clientservice.entities.CompanyAccount;
import com.ENSAPAY.Clientservice.entities.PersonalAccount;
import com.ENSAPAY.Clientservice.repositories.CompanyAccountRepository;
import com.ENSAPAY.Clientservice.repositories.PersonalAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompanyAccountRepository companyRepository, PersonalAccountRepository personalRepository) {
		return args -> {

			personalRepository.save ( new PersonalAccount ("Abdellah", "AHBANE","JC556633","0608632756","abdellah@ahbane.me",200d) );
			personalRepository.save ( new PersonalAccount ("Mounib", "Elboujbaoui","JD908611","0690287735","contact@mounib.me",5000d ) );

			companyRepository.save ( new CompanyAccount ( "Maroc Telecom","0537630056","contact@IAM.ma",20000d) );
			companyRepository.save ( new CompanyAccount ( "RADEMA","053711756","contact@RADEMA.ma",50000d) );
			companyRepository.save ( new CompanyAccount ( "CTM","0537663856","contact@CTM.ma",20000d ) );
			companyRepository.save ( new CompanyAccount ( "SUPRATEUR","0537113812","contact@SUPRATEUR.ma",20000d ) );

		};
	}

}
