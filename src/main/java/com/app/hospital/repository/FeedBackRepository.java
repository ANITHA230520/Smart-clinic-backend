package com.app.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.app.hospital.entity.FeedBack;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBack, Integer> {
	

}
