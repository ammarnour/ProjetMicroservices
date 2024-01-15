package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import tn.iit.entity.Coach;
import tn.iit.entity.FootballTeam;
import tn.iit.repository.CoachRepository;
import tn.iit.repository.FootballTeamRepository;
import tn.iit.request.CreateCoachRequest;
import tn.iit.response.CoachResponse;
import tn.iit.response.FootballTeamResponse;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CoachService {

    @Autowired
    private CoachRepository coachRepository;
@Autowired
private FootballTeamRepository footballTeamRepository;
    public String createCoach(CreateCoachRequest createCoachRequest , Long id) {

        try {
            Coach coach = new Coach();
            coach.setFirstName(createCoachRequest.getFirstName());
            coach.setLastName(createCoachRequest.getLastName());

            FootballTeam footballTeam = footballTeamRepository.getReferenceById(id);

            if (footballTeam==null){

                return "team not found";
            }
            else if(footballTeam.getCoach()!=null){

                return "Team already have a coach";
            }

            else{
                coach.setFootballTeam(footballTeam);
                coachRepository.save(coach);
                footballTeam.setCoach(coach);
                footballTeamRepository.save(footballTeam);

                return "Coach Created";
            }
        }catch(Exception e){
            return e.getMessage();
        }

    }

    public CoachResponse getCoachById(Long id) {
        return coachRepository.findById(id).map(CoachResponse::new).orElseThrow(() -> new EntityNotFoundException("Coach not found with id: " + id));
    }

    public List<CoachResponse> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream().map(CoachResponse::new).collect(Collectors.toList());
    }

    public String updateCoach(Long id,Long team_id, CreateCoachRequest createCoachRequest) {
        try{
            Coach coach = coachRepository.getReferenceById(id);
            FootballTeam footballTeam = footballTeamRepository.getReferenceById(team_id);


            if (footballTeam==null ){
                return "team not found";
            }
            else if(footballTeam.getCoach()!=null && footballTeam.getCoach()!=coach ){

                return "Team already have a coach";
            }

            else{
                coach.setFirstName(createCoachRequest.getFirstName());
                coach.setLastName(createCoachRequest.getLastName());
                coach.setFootballTeam(footballTeam);
                coachRepository.save(coach);
                footballTeam.setCoach(coach);
                footballTeamRepository.save(footballTeam);

                return "Coach Updated";
            }

        }catch (Exception e){
           return e.getMessage();
        }
    }

    @Transactional
    public List<CoachResponse> deleteCoach(Long id) {
        Optional<Coach> optionalCoach = coachRepository.findById(id);
        if (optionalCoach.isPresent()) {
            Coach coach = optionalCoach.get();
            coachRepository.removeCoachAssociation(coach);
        }
        coachRepository.deleteById(id);
        return getAllCoaches();

    }
}