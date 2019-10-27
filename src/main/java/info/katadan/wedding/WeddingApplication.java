package info.katadan.wedding;

import info.katadan.wedding.init.InitialDataSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cz.katadan.wedding")
@EntityScan("cz.katadan.wedding")
public class WeddingApplication {

    private final InitialDataSet initialDataSet;

    @Autowired
    public WeddingApplication(InitialDataSet initialDataSet) {
        this.initialDataSet = initialDataSet;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeddingApplication.class, args);
    }

    @Bean
    public InitializingBean init() {
        return initialDataSet.load();
    }
}
