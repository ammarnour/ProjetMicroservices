package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.entity.FootballTeam;
import tn.iit.entity.Stadium;

@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {

    @Modifying
    @Query("UPDATE Player p SET p.footballTeam = null WHERE p.footballTeam = :footballTeam")
    void removeFootballTeamPlayerAssociation(@Param("footballTeam") FootballTeam footballTeam);

    @Modifying
    @Query("UPDATE Coach m SET m.footballTeam = null WHERE m.footballTeam = :footballTeam")
    void removeFootballTeamCoachAssociation(@Param("footballTeam") FootballTeam footballTeam);

    @Override
    FootballTeam getReferenceById(Long id);

}
