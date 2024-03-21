package com.app.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.hospital.dto.FeedBackDTO;
import com.app.hospital.entity.FeedBack;
import com.app.hospital.service.FeedBackService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/feedBacks")

public class FeedBackController {

	@Autowired
	private FeedBackService feedBackService;
	
	// Mapping the add feedback details from Feedback Service 

	@PostMapping("/feedBack")
	public FeedBack saveFeedBack(@RequestBody FeedBackDTO feedBackDTO) {
	FeedBack feedBack=feedBackService.saveFeedBack(feedBackDTO);
	return feedBack;
	}
	
	@GetMapping

	public ResponseEntity<List<FeedBackDTO>> findAll() {

	List<FeedBackDTO> list = feedBackService.findAll();

	return new ResponseEntity<List<FeedBackDTO>>(list,HttpStatus.OK);

	}

}
