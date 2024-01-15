package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
