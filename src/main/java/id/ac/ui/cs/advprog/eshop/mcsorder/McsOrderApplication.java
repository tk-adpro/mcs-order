package id.ac.ui.cs.advprog.eshop.mcsorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "id.ac.ui.cs.advprog.eshop.mcsorder")
@EntityScan(basePackages = "id.ac.ui.cs.advprog.eshop.mcsorder.model")
@EnableAsync
public class McsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(McsOrderApplication.class, args);
    }

}
