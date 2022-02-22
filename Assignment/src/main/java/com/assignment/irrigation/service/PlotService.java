package com.assignment.irrigation.service;

import com.assignment.irrigation.requests.AddPlotRequest;
import org.springframework.http.ResponseEntity;

public interface PlotService {
    ResponseEntity<?> addPlot(AddPlotRequest addPlotRequest);
    ResponseEntity<?> editPlot(String plotId,AddPlotRequest addPlotRequest);
    ResponseEntity<?> viewPlots(Integer pageNumber,Integer size,String sortKey,Integer sortDir);
}
