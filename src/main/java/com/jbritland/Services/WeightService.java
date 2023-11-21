package com.jbritland.Services;

import java.util.List;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewWeightDTO;
import com.jbritland.DTOs.ResponseWeightDTO;

public interface WeightService {

	public ResponseWeightDTO addWeight(NewWeightDTO weight);
	public List<ResponseWeightDTO> getUserWeights(EmailWrapper email);
	
}
