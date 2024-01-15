package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateCoachRequest;
import tn.iit.request.CreatePlayerRequest;
import tn.iit.response.CoachResponse;
import tn.iit.response.PlayerResponse;
import tn.iit.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("")
    public PlayerResponse createPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) {
        return playerService.createPlayer(createPlayerRequest);
    }
    @GetMapping("")
    public List<PlayerResponse> getAllPlayers(){return playerService.getAllPlayers();
    }
    @PutMapping("/{id}")
    public PlayerResponse updatePlayer(@PathVariable Long id, @RequestBody CreatePlayerRequest createPlayerRequest){
        return playerService.updatePlayer(id, createPlayerRequest);
    }
    @DeleteMapping("/{id}")
    public List<PlayerResponse> deletePlayer(@PathVariable Long id){
        return playerService.deletePlayer(id);
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }
}
