package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.entity.Stadium;
import tn.iit.repository.StadiumRepository;
import tn.iit.request.CreateStadiumRequest;
import tn.iit.response.StadiumResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    public StadiumResponse createStadium(CreateStadiumRequest createStadiumRequest) {
        Stadium stadium = new Stadium();
        stadium.setName(createStadiumRequest.getName());
        stadium.setCapacity(createStadiumRequest.getCapacity());
        stadium = stadiumRepository.save(stadium);
        return new StadiumResponse(stadium);
    }

    public List<StadiumResponse> getAllStadiums() {
        List<Stadium> stadiumList = stadiumRepository.findAll();
        return stadiumList.stream().map(StadiumResponse::new).collect(Collectors.toList());
    }

    public StadiumResponse updateStadium(Long id, CreateStadiumRequest createStadiumRequest) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            Stadium stadium = stadiumOptional.get();
            stadium.setName(createStadiumRequest.getName());
            stadium.setCapacity(createStadiumRequest.getCapacity());
            stadium = stadiumRepository.save(stadium);
            return new StadiumResponse(stadium);
        } else {
            throw new EntityNotFoundException("Stadium with ID " + id + " not found.");
        }
    }

    public StadiumResponse getStadiumById(Long id) {
        return stadiumRepository.findById(id).map(StadiumResponse::new).orElseThrow(() -> new EntityNotFoundException("Stadium not found with id: " + id));
    }

    @Transactional
    public List<StadiumResponse> deleteStadium(Long id) {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);
        if (stadiumOptional.isPresent()) {
            Stadium stadium = stadiumOptional.get();
            stadiumRepository.removeStadiumAssociation(stadium);
        }
        stadiumRepository.deleteById(id);
        return getAllStadiums();
    }

}
