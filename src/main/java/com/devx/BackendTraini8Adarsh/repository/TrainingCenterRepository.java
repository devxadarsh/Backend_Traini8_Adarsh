package com.devx.BackendTraini8Adarsh.repository;

import com.devx.BackendTraini8Adarsh.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

}
