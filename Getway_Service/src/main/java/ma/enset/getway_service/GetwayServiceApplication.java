package ma.enset.getway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GetwayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayServiceApplication.class, args);
    }
    //@Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("r1", r -> r.path("/customers/**").uri("lb://Customer_Service"))
                .route("r2", r -> r.path("/products/**").uri("lb://Inventory_Service"))
                .build();
    }
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                        DiscoveryLocatorProperties dlp){

        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);

    }
}
