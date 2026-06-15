package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {

    private String name = "Ella";

    @Autowired
    private Parrot2 parrot; // 등록된 빈이어야 함.

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }

    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }
}
