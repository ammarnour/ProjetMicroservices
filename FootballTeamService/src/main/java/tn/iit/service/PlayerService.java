package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.entity.Player;
import tn.iit.entity.FootballTeam;
import tn.iit.repository.PlayerRepository;
import tn.iit.repository.FootballTeamRepository;
import tn.iit.request.CreatePlayerRequest;
import tn.iit.response.PlayerResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FootballTeamRepository footballTeamRepository;

    public PlayerResponse createPlayer(CreatePlayerRequest createPlayerRequest) {
        Player player = new Player();
        player.setFirstName(createPlayerRequest.getFirstName());
        player.setLastName(createPlayerRequest.getLastName());
        player.setNationality(createPlayerRequest.getNationality());
        player.setRole(createPlayerRequest.getRole());
        player = playerRepository.save(player);
        return new PlayerResponse(player);
    }

    public PlayerResponse updatePlayer(Long id, CreatePlayerRequest createPlayerRequest) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setFirstName(createPlayerRequest.getFirstName());
            player.setLastName(createPlayerRequest.getLastName());
            player.setNationality(createPlayerRequest.getNationality());
            player.setRole(createPlayerRequest.getRole());
            player = playerRepository.save(player);
            return new PlayerResponse(player);
        } else {
            throw new EntityNotFoundException("Player with ID " + id + " not found");
        }
    }

    public List<PlayerResponse> deletePlayer(Long id){
        playerRepository.deleteById(id);
        return getAllPlayers();
    }

    public PlayerResponse getPlayerById(Long id) {
        Player player = playerRepository.findById(id).get();
        return new PlayerResponse(player);
    }

    public List<PlayerResponse> getAllPlayers(){
        List<Player> playerList = playerRepository.findAll();
        return playerList.stream().map(PlayerResponse::new).collect(Collectors.toList());
    }
}
