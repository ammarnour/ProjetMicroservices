package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateStadiumRequest;
import tn.iit.response.StadiumResponse;
import tn.iit.service.StadiumService;

import java.util.List;

@RestController
@RequestMapping("/api/stadium")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @PostMapping("")
    public StadiumResponse createStadium(@RequestBody CreateStadiumRequest createStadiumRequest) {
        return stadiumService.createStadium(createStadiumRequest);
    }
    @GetMapping("")
    public List<StadiumResponse> getStadium(){
        return stadiumService.getAllStadiums();
    }
    @GetMapping("/{id}")
    public StadiumResponse getStadiumById(@PathVariable Long id) {
        return stadiumService.getStadiumById(id);
    }

    @PutMapping("/{id}")
    public StadiumResponse updateStadium(@PathVariable Long id, @RequestBody CreateStadiumRequest createStadiumRequest) {
        return stadiumService.updateStadium(id, createStadiumRequest);
    }
    @DeleteMapping("/{id}")
    public List<StadiumResponse> deleteStadium(@PathVariable Long id){
        return stadiumService.deleteStadium(id);
    }
}
