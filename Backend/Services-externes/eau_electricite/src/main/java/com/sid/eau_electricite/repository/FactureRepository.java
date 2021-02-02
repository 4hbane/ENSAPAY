package com.sid.eau_electricite.repository;

import com.sid.eau_electricite.entity.FactureEE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<FactureEE,Long> {
    public List<FactureEE> getFacturesByNumContrat(Long numContrat);
    public List<FactureEE> getFacturesByNumContratAndPaid(Long numContrat, boolean paid);
}
