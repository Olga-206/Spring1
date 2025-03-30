package app.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class Timer {

    private final Long nanoTime = System.nanoTime();

    public Long getTime() {
        return nanoTime;
    }
}
