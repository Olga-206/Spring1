package app.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public abstract class Animal {
}

@Component
@Qualifier("dog")
class Dog extends Animal {

    public String toString() {
        return "I'm a Dog";
    }

}
