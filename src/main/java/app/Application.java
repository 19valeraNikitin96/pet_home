package app;

import app.controller.model.AdvertisementJSON;
import app.repository.advertisement.AdvertisementRepository;
import app.repository.advertisement.impl.AdvertisementRepositoryImpl;
import app.service.advertisemnt.utils.AdvertisementUtils;
import app.service.advertisemnt.utils.impl.AdvertisementsUtilsImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Bean
    public AdvertisementRepository advertisementRepository() {
        return new AdvertisementRepositoryImpl();
    }

    @Bean
    public AdvertisementUtils advertisementUtils(){
        return new AdvertisementsUtilsImpl();
    }
}
