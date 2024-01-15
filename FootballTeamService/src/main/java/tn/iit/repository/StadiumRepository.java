package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    @Modifying
    @Query("UPDATE FootballTeam t SET t.stadium = null WHERE t.stadium = :stadium")
    void removeStadiumAssociation(@Param("stadium") Stadium stadium);
}
