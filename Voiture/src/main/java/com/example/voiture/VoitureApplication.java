package com.example.voiture;

import com.example.voiture.entites.Client;
import com.example.voiture.entites.Voiture;
import com.example.voiture.repositories.VoitureRepository;
import com.example.voiture.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository,
                                        ClientService clientService){
        return args -> {
            Client c1 = clientService.clientById(1L);
            Client c2 = clientService.clientById(2L);

            voitureRepository.save(new Voiture(null, "Dacia","26 A 1234", "Sepway", 1L, c1));
            voitureRepository.save(new Voiture(null, "Renault","26 B 123456", "Clio", 1L, c1));
            voitureRepository.save(new Voiture(null, "Kia","72 A 765432", "Picanto", 2L, c2));
        };
    }

}
