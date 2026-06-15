package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;

public class ProjectConfig2 {

    @Bean
    Parrot parrot1() {
        var parrot = new Parrot();
        parrot.setName("Parrot");
        return parrot;
    }

    @Bean(name = "hurray")
    Parrot parrot2() {
        var parrot = new Parrot();
        parrot.setName("hurray");
        return parrot;
    }

    @Bean
    Parrot parrot3() {
        var parrot = new Parrot();
        parrot.setName("Banggu");
        return parrot;
    }

}
