package tn.iit.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iit.entity.Stadium;
import tn.iit.response.StadiumResponse;

@FeignClient(value = "team-service", path = "/api/stadium")
public interface FootballTeamServiceFeignClient {

    @GetMapping("/{id}")
    public Stadium getStadiumById(@PathVariable long id);
}
