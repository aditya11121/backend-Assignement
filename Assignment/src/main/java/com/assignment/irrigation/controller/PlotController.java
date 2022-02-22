package com.assignment.irrigation.controller;

import com.assignment.irrigation.requests.AddPlotRequest;
import com.assignment.irrigation.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plot")
public class PlotController {
    @Autowired
    PlotService plotService;

    @PostMapping()
    public ResponseEntity<?> addPlot(@RequestBody AddPlotRequest request){
        return plotService.addPlot(request);
    }
    @PutMapping()
    public ResponseEntity<?> editPlot(@RequestParam String plotId,@RequestBody AddPlotRequest request){
        return plotService.editPlot(plotId,request);
    }
    @GetMapping()
    public ResponseEntity<?> examView(  @RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(defaultValue = "10") Integer size,
                                      @RequestParam(defaultValue = "examId") String sortKey, @RequestParam(defaultValue = "0") Integer sortDir) {
        return plotService.viewPlots(pageNumber, size, sortKey, sortDir);

    }
}
