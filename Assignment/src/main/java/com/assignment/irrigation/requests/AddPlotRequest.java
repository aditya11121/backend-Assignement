package com.assignment.irrigation.requests;

import com.assignment.irrigation.collections.subCollection.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPlotRequest {
    private Double  area;
    private Double average_inflow_rate;
    private Double area_watered_per_irrigation;
    private Double volume_water_per_irrigation;
    private Integer irrigation_after_hours;
    private Location location;
}
