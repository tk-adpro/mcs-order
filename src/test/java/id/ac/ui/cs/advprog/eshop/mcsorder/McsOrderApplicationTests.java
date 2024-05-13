// McsOrderApplicationTests.java
package id.ac.ui.cs.advprog.eshop.mcsorder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = McsOrderApplication.class)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class McsOrderApplicationTests {

    @Test
    void contextLoads() {
    }

}