package com.actuator.health;


import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean EverythingIsFine = true;

        if (EverythingIsFine) {
            return Health.up()
                    .withDetail("myService", "Working well")
                    .build();
        }
        return Health.down()
                .withDetail("myService", "Something's wrong")
                .build();
    }
}
