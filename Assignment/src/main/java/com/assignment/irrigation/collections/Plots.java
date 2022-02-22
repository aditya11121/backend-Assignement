package com.assignment.irrigation.collections;

import com.assignment.irrigation.collections.subCollection.Location;
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
public class Plots {
    @Id
    private ObjectId plotId;
    private Double  area;
    private Double average_inflow_rate;
    private Double area_watered_per_irrigation;
    private Double volume_water_per_irrigation;
    private Location location;
    private Integer irrigation_after_hours;
    private Boolean last_cycle_success;
    private Instant last_irrigation;
    private Integer fail_count;

}
