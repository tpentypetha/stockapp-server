package gr.mod.mil.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@EntityScan(basePackages = "gr.mod.mil.stock.dal.model")
public class StockApplication {

    private final static Logger log = LoggerFactory.getLogger(StockApplication.class);

    public static void main(String[] args) {
        log.info("Starting Stock server...");
        SpringApplication.run(StockApplication.class, args);
    }

}
