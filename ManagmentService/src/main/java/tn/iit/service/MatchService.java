package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.entity.Match;
import tn.iit.entity.Stadium;
import tn.iit.proxy.FootballTeamServiceFeignClient;
import tn.iit.repository.MatchRepository;
import tn.iit.request.CreateMatchRequest;
import tn.iit.response.MatchResponse;
import tn.iit.response.MatchResponse_st;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private FootballTeamServiceFeignClient feignClient;

    public MatchResponse createMatch(CreateMatchRequest createMatchRequest) {

        Match match = new Match();
        match.setId(createMatchRequest.getId());
        match.setArbiter(createMatchRequest.getArbiter());

        match.setTeamhomeId(createMatchRequest.getTeamhomeId());
        match.setStadeId(createMatchRequest.getStadeId());
        match.setTeamvisitorId(createMatchRequest.getTeamvisitorId());
        match.setSpectatorsNumber(createMatchRequest.getSpectatorsNumber());
        match.setMatchDate(createMatchRequest.getMatchDate());
        match = matchRepository.save(match);
        return new MatchResponse(match);
    }


    public List<MatchResponse> getAllMatches() {
        List<Match> matchList = matchRepository.findAll();
        return matchList.stream().map(MatchResponse::new).collect(Collectors.toList());
    }

    public MatchResponse_st getMatchById(Long id) {
        Optional<Match> matchOptional = matchRepository.findById(id);

        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            Stadium stadium = (Stadium) feignClient.getStadiumById(match.getStadeId());
            MatchResponse_st matchResponseSt=new MatchResponse_st();
            matchResponseSt.setId(match.getId());
            matchResponseSt.setMatchDate(match.getMatchDate());
            matchResponseSt.setArbiter(match.getArbiter());
            matchResponseSt.setTeamhomeId(match.getTeamhomeId());
            matchResponseSt.setTeamvisitorId(match.getTeamvisitorId());
            matchResponseSt.setSpectatorsNumber(match.getSpectatorsNumber());
            matchResponseSt.setStade(stadium);
            return matchResponseSt;
        } else {
            throw new EntityNotFoundException("Match with ID " + id + " not found.");
        }
    }

    public void deleteByid(Long id) {
        matchRepository.deleteById(id);
    }
}
