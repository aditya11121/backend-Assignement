package com.assignment.irrigation.repository;

import com.assignment.irrigation.collections.Plots;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PlotsRepository extends MongoRepository<Plots, ObjectId> {
    Plots findByPlotId(Object plotId);
    List<Plots> findAllByLast_irrigationBefore(Instant time);
    List<Plots> findAllByFail_countGreaterThanEqual(int count);
}
