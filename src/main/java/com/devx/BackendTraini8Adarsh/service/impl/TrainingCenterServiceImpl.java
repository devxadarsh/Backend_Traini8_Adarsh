package com.devx.BackendTraini8Adarsh.service.impl;

import com.devx.BackendTraini8Adarsh.exception.DataAlreadyExistsException;
import com.devx.BackendTraini8Adarsh.mapper.TrainingCenterMapper;
import com.devx.BackendTraini8Adarsh.model.TrainingCenter;
import com.devx.BackendTraini8Adarsh.repository.TrainingCenterRepository;
import com.devx.BackendTraini8Adarsh.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private final TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterServiceImpl(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;
    }

    @Override
    public TrainingCenter createTrainingCenter(TrainingCenter request) {
        TrainingCenterMapper trainingCenterMapper = new TrainingCenterMapper();
        if (trainingCenterRepository.existsByCenterCode(request.getCenterCode())) {
            throw new DataAlreadyExistsException("Training center with code " + request.getCenterCode() + " already exists.");
        }else if(trainingCenterRepository.existsByContactPhone(request.getContactPhone())){
            throw new DataAlreadyExistsException("Contact number " + request.getContactPhone() + " is already linked with another Account.");
        }else if(trainingCenterRepository.existsByContactEmail(request.getContactEmail())){
            throw new DataAlreadyExistsException("Email Id " + request.getContactEmail() + " is already linked with another Account");
        }
        return trainingCenterRepository.save(trainingCenterMapper.mapToTrainingCenter(request));
    }

    @Override
    public List<TrainingCenter> findAll() {
        return trainingCenterRepository.findAll();
    }

    @Override
    public List<String> getTrainingCenter() {
        return trainingCenterRepository.findAll().stream().map(TrainingCenter::getCenterName).collect(Collectors.toList());
    }
}
