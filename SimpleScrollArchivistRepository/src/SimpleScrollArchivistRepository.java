package com.scrollarchivist.simplescrollarchivistrepository;
import com.scrollarchivist.simplescrollarchivistrepository.controllers.MainController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author Mathaus
 */
@Configuration
@ComponentScan(basePackages = "com.scrollarchivist")
public class SimpleScrollArchivistRepository {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleScrollArchivistRepository.class)) {
            SimpleScrollArchivistRepository app = context.getBean(SimpleScrollArchivistRepository.class);
            MainController launcher = context.getBean(MainController.class);
            launcher.start();
        }
    }
}