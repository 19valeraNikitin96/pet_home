package app;

import app.controller.model.StudentJSON;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;

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
    public StudentDatabaseService databaseService() {
        return new StudentDatabaseService();
    }

//    public abstract class DatabaseService{
//        private HashMap<Integer, >
//    }

    public static class StudentDatabaseService {
       private HashMap<Integer, StudentJSON> db;

       public StudentDatabaseService(){
           db = new HashMap<>();
           db.put(
                   1,
                   new StudentJSON("Sasha", "Sidorov", 15, "#196", Arrays.asList("Java", "JS"))
           );
           db.put(
                   2,
                   new StudentJSON("Valerii", "Nikitin", 25, "NTUU KPI named by Ihor Sikorsky", Arrays.asList("Java", "Python"))
           );
           db.put(
                   3,
                   new StudentJSON("Platon", "Todorashko", 15, "KPI", Arrays.asList("Java"))
           );
           db.put(
                   4,
                   new StudentJSON("Rostik", "Perinkiy", 15, "???", Arrays.asList("Java"))
           );
           db.put(
                   5,
                   new StudentJSON("Dima", "???", 15, "???", Arrays.asList("Java"))
           );
       }

       public StudentJSON getStudent(Integer id) {
           return db.get(id);
       }

       public void deleteStudent(Integer id) {
           db.remove(id);
       }

       public Integer createStudent(StudentJSON json) {
           int max = -1;
           for (Integer id : db.keySet()) {
               if (max < id) {
                   max = id;
               }
           }

           int id = max + 1;
           db.put(id, json);
           return id;
       }

        public void updateStudent(Integer studentId, StudentJSON json) {
            if (!db.containsKey(studentId)){
                throw new RuntimeException("Student with such ID does not exist");
            }
            db.put(studentId, json);
        }
    }
}
