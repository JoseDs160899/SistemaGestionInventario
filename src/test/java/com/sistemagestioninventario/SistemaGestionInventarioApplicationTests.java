package com.sistemagestioninventario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:inventario-test")
class SistemaGestionInventarioApplicationTests {

    @Test
    void contextLoads() {
    }
}