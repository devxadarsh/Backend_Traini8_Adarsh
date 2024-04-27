package com.devx.BackendTraini8Adarsh.service;


import com.devx.BackendTraini8Adarsh.model.TrainingCenter;

import java.util.List;

public interface TrainingCenterService{

    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

    List<TrainingCenter> findAll();

    List<String> getTrainingCenter();
}
