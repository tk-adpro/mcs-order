package id.ac.ui.cs.advprog.eshop.mcsorder.config;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;
import static org.junit.jupiter.api.Assertions.*;

class SwaggerConfigTest {

    @Test
    void testApi() {
        SwaggerConfig swaggerConfig = new SwaggerConfig();
        Docket docket = swaggerConfig.api();

        assertNotNull(docket);
        assertEquals(Docket.class, docket.getClass());
    }
}