package org.scoula.app;

import org.scoula.domain.Parrot;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

//        Parrot parrot = new Parrot();
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        String string = context.getBean(String.class);
        System.out.println(string);

        Integer integer = context.getBean(Integer.class);
        System.out.println(integer);
    }
}