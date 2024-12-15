package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
        @Bean
        CommandLineRunner initialiserBaseDeDonnees(ClientRepository clientRepository) {
            return args -> {
                Client client =new Client( "Daali Mohamed Saad", 25);
                clientRepository.save(client);
                Client client1 =new Client( "Mohamed", 30);
                clientRepository.save(client1);
                Client client2 =new Client("DAALI", 35);
                clientRepository.save(client2);
            };
        }
    }
