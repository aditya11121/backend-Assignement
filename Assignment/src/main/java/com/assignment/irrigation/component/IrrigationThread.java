package com.assignment.irrigation.component;

import com.assignment.irrigation.collections.AlertTable;
import com.assignment.irrigation.collections.Plots;
import com.assignment.irrigation.repository.AlertRepository;
import com.assignment.irrigation.repository.PlotsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class IrrigationThread {
    @Autowired
    PlotsRepository plotsRepository;
    @Autowired
    AlertRepository alertRepository;

    @Scheduled(cron = "0 0 * * * *")
    public int everyHourThread() {
        List<Plots> plots=plotsRepository.findAllByLast_irrigationBefore(Instant.now());
        if (plots.isEmpty())
            return 0;
        plots.forEach(source -> {
            Calendar cal = Calendar.getInstance();cal.setTime(new Date());
            cal.add(Calendar.HOUR_OF_DAY,source.getIrrigation_after_hours());
            if (cal.getTime().toInstant().toEpochMilli() <=Instant.now().toEpochMilli()){
//                SENSOR - Success
                if (true) {
                    source.setLast_irrigation(Instant.now());
                    source.setLast_cycle_success(true);
                }
                else{
                    source.setLast_cycle_success(false);
                    if (source.getFail_count()==null)
                        source.setFail_count(0);
                    source.setFail_count(source.getFail_count()+1);
                }
            }
        });
        plotsRepository.saveAll(plots);
        return 1;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public int midnight_thread() {
        List<Plots> plots=plotsRepository.findAllByFail_countGreaterThanEqual(5);
        if (plots.isEmpty())
            return 0;
        List<AlertTable> alertTables=new ArrayList<>();
        plots.forEach(source -> {
            alertTables.add(new AlertTable(new ObjectId(),source.getFail_count(),Instant.now()));
        });
        alertRepository.saveAll(alertTables);
        return 1;
    }

}
