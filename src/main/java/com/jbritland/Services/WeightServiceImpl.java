package com.jbritland.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jbritland.DTOs.EmailWrapper;
import com.jbritland.DTOs.NewWeightDTO;
import com.jbritland.DTOs.ResponseWeightDTO;
import com.jbritland.Exceptions.UserNotFoundException;
import com.jbritland.Repositories.UserRepo;
import com.jbritland.Repositories.WeightRepo;

@Service
public class WeightServiceImpl implements WeightService {
	
	private final WeightRepo wRepo;
	private final UserRepo uRepo;
	
	public WeightServiceImpl(WeightRepo wRepo, UserRepo uRepo) {
		this.wRepo = wRepo;
		this.uRepo = uRepo;
	}

	@Override
	public ResponseWeightDTO addWeight(NewWeightDTO weight) {
		if (uRepo.findByEmail(weight.getEmail()) == null) {
			throw new UserNotFoundException("No account found with the provided email", weight.getEmail());
		}
		return ResponseWeightDTO.of(wRepo.save(weight.toWeight()));
	}

	@Override
	public List<ResponseWeightDTO> getUserWeights(EmailWrapper email) {
		return wRepo.findByWeightIdUserEmail(email.getEmail()).stream()
				.map(ResponseWeightDTO::of)
				.collect(Collectors.toList());
	}

}
