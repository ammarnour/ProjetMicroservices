package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateMatchRequest;
import tn.iit.response.MatchResponse;
import tn.iit.response.MatchResponse_st;
import tn.iit.service.MatchService;
import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public MatchResponse createMatch(@RequestBody CreateMatchRequest createMatchRequest) {
        return matchService.createMatch(createMatchRequest);
    }

    @GetMapping
    public List<MatchResponse> getMatches (){
        return matchService.getAllMatches();
    }

    @GetMapping("{id}")
    public MatchResponse_st getMatchById (@PathVariable Long id){
        return matchService.getMatchById(id);
    }

    @DeleteMapping("{id}")
    public void deleteMatch(@PathVariable Long id){
        matchService.deleteByid(id);
    }
}