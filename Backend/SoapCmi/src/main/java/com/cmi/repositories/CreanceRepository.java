package com.cmi.repository;

import com.cmi.entities.Creance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreanceRepository extends JpaRepository<Creance,Long> {
    public Creance findCreanceByCodeCreance( Long codeCreance);

}
