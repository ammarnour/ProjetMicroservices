package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateArbiterRequest; // Updated request class name
import tn.iit.response.ArbiterResponse; // Updated response class name
import tn.iit.service.ArbiterService; // Updated service class name

import java.util.List;

@RestController
@RequestMapping("/api/arbiter")
public class ArbiterController {

    @Autowired
    private ArbiterService arbiterService;

    @PostMapping("")
    public ArbiterResponse createArbiter(@RequestBody CreateArbiterRequest createArbiterRequest) { 
        return arbiterService.createArbiter(createArbiterRequest);
    }

    @GetMapping("")
    public List<ArbiterResponse> getAllArbiters() {
        return arbiterService.getAllArbiters();
    }

    @GetMapping("/{id}")
    public ArbiterResponse getArbiterById(@PathVariable Long id) {
        return arbiterService.getArbiterById(id);
    }

    @PutMapping("/{id}")
    public ArbiterResponse updateArbiter(@PathVariable Long id, @RequestBody CreateArbiterRequest createArbiterRequest) {
        return arbiterService.updateArbiter(id, createArbiterRequest);
    }
}
