package tn.iit.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.iit.entity.Arbiter;
import tn.iit.repository.ArbiterRepository;
import tn.iit.request.CreateArbiterRequest;
import tn.iit.response.ArbiterResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArbiterService { 

    @Autowired
    private ArbiterRepository arbiterRepository;

    public ArbiterResponse createArbiter(CreateArbiterRequest createArbiterRequest) { 
        Arbiter arbiter = new Arbiter();
        arbiter.setFirstName(createArbiterRequest.getFirstName());
        arbiter.setLastName(createArbiterRequest.getLastName());
        arbiter = arbiterRepository.save(arbiter);
        return new ArbiterResponse(arbiter);
    }

    public List<ArbiterResponse> getAllArbiters() { 
        List<Arbiter> arbiterList = arbiterRepository.findAll();
        return arbiterList.stream().map(ArbiterResponse::new).collect(Collectors.toList());
    }

    public ArbiterResponse getArbiterById(Long id) { 
        Optional<Arbiter> arbiterOptional = arbiterRepository.findById(id);
        if (arbiterOptional.isPresent()) {
            Arbiter arbiter = arbiterOptional.get();
            return new ArbiterResponse(arbiter);
        } else {
            throw new EntityNotFoundException("Arbiter with ID " + id + " not found."); 
        }
    }

    @Transactional
    public ArbiterResponse updateArbiter(Long id, CreateArbiterRequest createArbiterRequest) { 
        Optional<Arbiter> arbiterOptional = arbiterRepository.findById(id);
        if (arbiterOptional.isPresent()) {
            Arbiter arbiter = arbiterOptional.get();
            arbiter.setFirstName(createArbiterRequest.getFirstName());
            arbiter.setLastName(createArbiterRequest.getLastName());
            arbiter = arbiterRepository.save(arbiter);
            return new ArbiterResponse(arbiter);
        } else {
            throw new EntityNotFoundException("Arbiter with ID " + id + " not found."); 
        }
    }
}
