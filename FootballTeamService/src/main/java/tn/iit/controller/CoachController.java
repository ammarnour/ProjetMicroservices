package tn.iit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.iit.request.CreateCoachRequest;
import tn.iit.response.CoachResponse;
import tn.iit.service.CoachService;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/{id}")
    public String createCoach(@RequestBody CreateCoachRequest createCoachRequest, @PathVariable Long id) {
        return coachService.createCoach(createCoachRequest , id);
    }

    @GetMapping("")
    public List<CoachResponse> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @GetMapping("/{id}")
    public CoachResponse getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id);
    }

    @PutMapping("/{id}/{team_id}")
    public String updateCoach(@PathVariable Long id, @PathVariable Long team_id,@RequestBody CreateCoachRequest createCoachRequest) {
        return coachService.updateCoach(id, team_id,createCoachRequest);
    }

    @DeleteMapping("/{id}")
    public List<CoachResponse> deleteCoach(@PathVariable Long id) {
        return coachService.deleteCoach(id);
    }
}
