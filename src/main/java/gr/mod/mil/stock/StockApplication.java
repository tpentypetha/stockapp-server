package gr.mod.mil.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

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

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }

}
