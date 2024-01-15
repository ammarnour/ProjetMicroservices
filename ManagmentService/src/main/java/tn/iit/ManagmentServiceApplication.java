package tn.iit;
import tn.iit.proxy.FootballTeamServiceFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("tn.iit.proxy")
public class ManagmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagmentServiceApplication.class, args);
    }

}
