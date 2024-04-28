package com.devx.BackendTraini8Adarsh.mapper;


import com.devx.BackendTraini8Adarsh.model.TrainingCenter;

import java.time.Instant;

public class TrainingCenterMapper {

    public TrainingCenter mapToTrainingCenter(TrainingCenter request) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(request.getCenterName());
        trainingCenter.setCenterCode(request.getCenterCode());
        trainingCenter.setCreatedOn(Instant.now().toEpochMilli());
//        trainingCenter.setCreatedOn(System.currentTimeMillis());
        trainingCenter.setAddress(request.getAddress());
        trainingCenter.setStudentCapacity(request.getStudentCapacity());
        trainingCenter.setCoursesOffered(request.getCoursesOffered());
        trainingCenter.setCreatedOn(request.getCreatedOn());
        trainingCenter.setContactEmail(request.getContactEmail().toLowerCase());
        trainingCenter.setContactPhone(request.getContactPhone());
        return trainingCenter;
    }
}
