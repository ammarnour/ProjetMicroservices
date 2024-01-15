package tn.iit.configuration;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("FootballTeamService", r -> r.path("/FootballTeamService/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://FootballTeamService"))
                .route("ManagmentService", r -> r.path("/ManagmentService/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://ManagmentService")).build();
    }

}
