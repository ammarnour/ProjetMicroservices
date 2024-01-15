package tn.iit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Arbiter;

@Repository
public interface ArbiterRepository extends JpaRepository<Arbiter, Long> {

}
