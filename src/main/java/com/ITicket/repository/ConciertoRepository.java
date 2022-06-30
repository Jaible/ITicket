package com.ITicket.repository;

import com.ITicket.entity.Concierto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConciertoRepository extends CrudRepository<Concierto,Long>{
    
}
