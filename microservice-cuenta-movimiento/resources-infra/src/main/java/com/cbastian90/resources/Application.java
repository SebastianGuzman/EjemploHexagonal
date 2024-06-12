package com.cbastian90.resources;

import com.cbastian90.resources.adapter.in.example.ExampleAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan( basePackages = {"com.cbastian90.resources.config"},
                basePackageClasses = {
                        //General Dependencies
                        ExampleAdapter.class,
}
)

public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
