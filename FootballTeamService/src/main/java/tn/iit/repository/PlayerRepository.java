package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

