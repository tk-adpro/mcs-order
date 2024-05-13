// McsOrderApplication.java
package id.ac.ui.cs.advprog.eshop.mcsorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class McsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(McsOrderApplication.class, args);
    }

}
