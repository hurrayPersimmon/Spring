package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        //expected single matching bean but found 3
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        Parrot parrot = context.getBean("hurray", Parrot.class);
        System.out.println(parrot.getName());
    }

}
