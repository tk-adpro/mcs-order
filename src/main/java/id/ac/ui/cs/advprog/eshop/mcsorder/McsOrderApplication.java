package id.ac.ui.cs.advprog.eshop.mcsorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "id.ac.ui.cs.advprog.eshop.mcsorder")
@EntityScan(basePackages = "id.ac.ui.cs.advprog.eshop.mcsorder.model")
public class McsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(McsOrderApplication.class, args);
    }

}
