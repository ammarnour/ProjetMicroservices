package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Coach;
import tn.iit.entity.FootballTeam;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    @Modifying
    @Query("UPDATE FootballTeam t SET t.coach = null WHERE t.coach = :coach") 
    void removeCoachAssociation(@Param("coach") Coach coach);
    @Override
    Coach getReferenceById(Long id);
}
