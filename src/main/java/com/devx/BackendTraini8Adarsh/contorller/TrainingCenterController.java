package com.devx.BackendTraini8Adarsh.contorller;

import com.devx.BackendTraini8Adarsh.exceptionfilter.StringExtractor;
import com.devx.BackendTraini8Adarsh.model.TrainingCenter;
import com.devx.BackendTraini8Adarsh.service.TrainingCenterService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training-centers")
@Slf4j
public class TrainingCenterController {

    Logger logger = LoggerFactory.getLogger(TrainingCenterController.class);

    private final TrainingCenterService trainingCenterService;

    public TrainingCenterController(TrainingCenterService trainingCenterService) {
        this.trainingCenterService = trainingCenterService;
    }

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@RequestBody TrainingCenter request) {
        TrainingCenter trainingCenter = trainingCenterService.createTrainingCenter(request);
        return new ResponseEntity<>(trainingCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> findAll(){
        return new ResponseEntity<>(trainingCenterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/c")
    public ResponseEntity<List<String>> getTrainingCenter(){
        return new ResponseEntity<>(trainingCenterService.getTrainingCenter(), HttpStatus.OK);
    }


    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        String message = StringExtractor.extractString(e.getMessage(), "messageTemplate='", "'}");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
