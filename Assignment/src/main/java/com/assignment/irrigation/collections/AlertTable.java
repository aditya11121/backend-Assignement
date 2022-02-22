package com.assignment.irrigation.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "plots")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlertTable {
    @Id
    private ObjectId plotId;
    private Integer failCount;
    private Instant timestamp;
}
