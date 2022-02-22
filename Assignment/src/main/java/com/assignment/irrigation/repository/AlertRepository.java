package com.assignment.irrigation.repository;

import com.assignment.irrigation.collections.AlertTable;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends MongoRepository<AlertTable, ObjectId> {

}
