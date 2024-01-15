package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.entity.Coach;
import tn.iit.entity.Player;
import tn.iit.entity.Stadium;
import tn.iit.entity.FootballTeam;
import tn.iit.repository.CoachRepository;
import tn.iit.repository.PlayerRepository;
import tn.iit.repository.StadiumRepository;
import tn.iit.repository.FootballTeamRepository;
import tn.iit.request.CreateFootballTeamRequest;
import tn.iit.response.CoachResponse;
import tn.iit.response.PlayerResponse;
import tn.iit.response.FootballTeamResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FootballTeamService {

    @Autowired
    private FootballTeamRepository footballTeamRepository;
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private StadiumRepository stadiumRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public FootballTeamResponse createFootballTeam(CreateFootballTeamRequest createFootballTeamRequest) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setName(createFootballTeamRequest.getName());
        footballTeam = footballTeamRepository.save(footballTeam);
        return new FootballTeamResponse(footballTeam);
    }

    public List<FootballTeamResponse> getAllFootballTeams() {
        List<FootballTeam> footballTeamList = footballTeamRepository.findAll();
        return footballTeamList.stream().map(FootballTeamResponse::new).collect(Collectors.toList());
    }

    public FootballTeamResponse getFootballTeamById(Long id) {
        FootballTeam footballTeam = footballTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FootballTeam not found with ID: " + id));
        return new FootballTeamResponse(footballTeam);
    }

    //public FootballTeamResponse updateFootballTeam(Long id, CreateFootballTeamRequest createFootballTeamRequest) {
      //  Optional<FootballTeam> footballTeamOptional = footballTeamRepository.findById(id);
        //if (footballTeamOptional.isPresent()) {
          //  FootballTeam footballTeam = footballTeamOptional.get();
            //footballTeam.setName(createFootballTeamRequest.getName());
            //footballTeam = footballTeamRepository.save(footballTeam);
            //return new FootballTeamResponse(footballTeam);
        //} else {
          //  throw new EntityNotFoundException("FootballTeam with ID " + id + " not found.");
        //}
    //}

    @Transactional
    public List<FootballTeamResponse> deleteFootballTeam(Long id) {
        Optional<FootballTeam> footballTeamOptional = footballTeamRepository.findById(id);
        if (footballTeamOptional.isPresent()) {
            FootballTeam footballTeam = footballTeamOptional.get();
            footballTeamRepository.removeFootballTeamCoachAssociation(footballTeam);
            footballTeamRepository.removeFootballTeamPlayerAssociation(footballTeam);
        }
        footballTeamRepository.deleteById(id);
        return getAllFootballTeams();
    }

    public FootballTeamResponse updateFootballTeamStadium(Long footballTeamId, Long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new EntityNotFoundException("Stadium not found with ID: " + stadiumId));
        FootballTeam footballTeam = footballTeamRepository.findById(footballTeamId).orElseThrow(() -> new EntityNotFoundException("FootballTeam not found with ID: " + footballTeamId));
        footballTeam.setStadium(stadium);
        footballTeam = footballTeamRepository.save(footballTeam);
        return new FootballTeamResponse(footballTeam);
    }

    public FootballTeamResponse updateFootballTeamCoach(Long footballTeamId, Long coachId) {
        Coach coach = coachRepository.findById(coachId).orElseThrow(() -> new EntityNotFoundException("Coach not found with ID: " + coachId));
        FootballTeam footballTeam = footballTeamRepository.findById(footballTeamId).orElseThrow(() -> new EntityNotFoundException("FootballTeam not found with ID: " + footballTeamId));
        footballTeam.setCoach(coach);
        coach.setFootballTeam(footballTeam);
        coachRepository.save(coach);
        footballTeam = footballTeamRepository.save(footballTeam);
        return new FootballTeamResponse(footballTeam);
    }

    public FootballTeamResponse addPlayerToFootballTeam(Long id, Long playerId) {
        FootballTeam footballTeam = footballTeamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FootballTeam not found with ID: " + id));
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new EntityNotFoundException("Player not found with ID: " + playerId));
        player.setFootballTeam(footballTeam);
        player = playerRepository.save(player);
        return new FootballTeamResponse(player.getFootballTeam());
    }

    public FootballTeamResponse removeFootballTeamStadium(Long id) {
        Optional<FootballTeam> footballTeamOptional = footballTeamRepository.findById(id);
        if (footballTeamOptional.isPresent()) {
            FootballTeam footballTeam = footballTeamOptional.get();
            footballTeam.setStadium(null);
            footballTeam = footballTeamRepository.save(footballTeam);
            return new FootballTeamResponse(footballTeam);
        } else {
            throw new EntityNotFoundException("FootballTeam with ID " + id + " not found.");
        }
    }

    public FootballTeamResponse removeFootballTeamCoach(Long id) {
        Optional<FootballTeam> footballTeamOptional = footballTeamRepository.findById(id);
        if (footballTeamOptional.isPresent()) {
            FootballTeam footballTeam = footballTeamOptional.get();
            Coach coach = footballTeam.getCoach();
            if (footballTeam.getCoach() != null) {
                coach.setFootballTeam(null);
                coachRepository.save(coach);
            }
            footballTeam.setCoach(null);
            footballTeam = footballTeamRepository.save(footballTeam);
            return new FootballTeamResponse(footballTeam);
        } else {
            throw new EntityNotFoundException("FootballTeam with ID " + id + " not found.");
        }
    }

    public FootballTeamResponse removePlayerFromFootballTeam(Long id, Long playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setFootballTeam(null);
            playerRepository.save(player);
        } else {
            throw new EntityNotFoundException("Player with ID " + id + " not found.");
        }
        return getFootballTeamById(id);
    }
}
