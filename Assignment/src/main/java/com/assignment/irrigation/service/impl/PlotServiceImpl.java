package com.assignment.irrigation.service.impl;

import com.assignment.irrigation.collections.Plots;
import com.assignment.irrigation.repository.PlotsRepository;
import com.assignment.irrigation.requests.AddPlotRequest;
import com.assignment.irrigation.service.PlotService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    PlotsRepository plotsRepository;
    @Override
    public ResponseEntity<?> addPlot(AddPlotRequest request) {
        if (request.getArea()==null || request.getArea_watered_per_irrigation()==null || request.getVolume_water_per_irrigation()==null
        || request.getIrrigation_after_hours()==null || request.getAverage_inflow_rate()==null || request.getLocation()==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Plots plot=new Plots();
        BeanUtils.copyProperties(request,plot);
        plot.setLast_irrigation(Instant.now());
        try {
            plot=plotsRepository.save(plot);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(plot,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> editPlot(String plotId, AddPlotRequest request) {
        if (plotId==null ||request.getArea()==null || request.getArea_watered_per_irrigation()==null || request.getVolume_water_per_irrigation()==null
                || request.getIrrigation_after_hours()==null || request.getAverage_inflow_rate()==null || request.getLocation()==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Plots plot=plotsRepository.findByPlotId(new ObjectId(plotId));
        BeanUtils.copyProperties(request,plot);
        try {
            plot=plotsRepository.save(plot);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(plot,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> viewPlots(Integer pageNumber, Integer size, String sortKey, Integer sortDir) {
        if ( pageNumber==null || size==null || sortKey==null || sortDir==null || size == 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Sort s = Sort.by(sortKey).ascending();
        if (sortDir == 1)
            s = Sort.by(sortKey).descending();
        Pageable page = PageRequest.of(pageNumber, size, s);
        Page<Plots> obj = plotsRepository.findAll(page);
        if (obj.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(obj,HttpStatus.OK);

    }

}
