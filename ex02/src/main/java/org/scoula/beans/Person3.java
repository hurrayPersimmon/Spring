package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person3 {

    private String name = "Ella";
    private final Parrot2 parrot;

    //AllRequiredConstructor는 final로 등록된 객체의 생성자를 생성.
    @Autowired
    public Person3(Parrot2 parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }
}
