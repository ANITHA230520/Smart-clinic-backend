package com.app.hospital.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.app.hospital.dto.FeedBackDTO;

import com.app.hospital.entity.FeedBack;

@Service
public interface FeedBackService {

	public FeedBack saveFeedBack(FeedBackDTO feedBackDTO);

	public List<FeedBackDTO> findAll();


}
