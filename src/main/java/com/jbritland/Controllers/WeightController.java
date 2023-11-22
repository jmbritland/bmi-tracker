package com.jbritland.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewWeightDTO;
import com.jbritland.DTOs.ResponseUserDTO;
import com.jbritland.DTOs.ResponseWeightDTO;
import com.jbritland.DTOs.UserHeightDTO;
import com.jbritland.Services.UserService;
import com.jbritland.Services.WeightService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://codesandbox.io")
public class WeightController {

	private final WeightService wService;
	private final UserService uService;
	
	public WeightController(WeightService wService, UserService uService) {
		this.wService = wService;
		this.uService = uService;
	}
	
	@PostMapping("/addWeight")
	public ResponseWeightDTO addWeight(@RequestBody @Valid NewWeightDTO weight) {
		return wService.addWeight(weight);
	}
	
	@PostMapping("/getUserWeights") 
	public List<ResponseWeightDTO> getUserWeights(@RequestBody EmailWrapper email) {
		return wService.getUserWeights(email);
	}
	
	@PostMapping("/updateHeight")
	public ResponseUserDTO updateHeight(@RequestBody @Valid UserHeightDTO user) {
		return uService.updateHeight(user);
	}
	
}
