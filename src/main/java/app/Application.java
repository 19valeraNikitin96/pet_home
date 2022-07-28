package app;

import app.service.advertisement.utils.AdvertisementUtils;
import app.service.advertisement.utils.impl.AdvertisementUtilsImpl;
import app.service.email.EmailService;
import app.service.location.utils.LocationUtils;
import app.service.location.utils.LocationUtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;

@SpringBootApplication
public class Application {

    @Autowired
    private EmailService emailService;

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
    public AdvertisementUtils advertisementUtils(){
        return new AdvertisementUtilsImpl();
    }

    @Bean
    public LocationUtils locationUtils(){
        return new LocationUtilsImpl();
    }

    @Value("${pethome.mail.username}")
    private String username;
    @Value("${pethome.mail.password}")
    private String password;
    @Value("${pethome.mail.host}")
    private String mailHost;
    @Value("${pethome.mail.port}")
    private Integer port;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(port);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean(name = "randomUUID")
    public UUID getRandomUUID(){
        return UUID.randomUUID();
    }
}
