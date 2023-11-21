package com.jbritland.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbritland.Entities.User;
import com.jbritland.Entities.Weight;
import com.jbritland.Entities.WeightId;

public interface WeightRepo extends JpaRepository<Weight, WeightId> {

	public List<Weight> findByWeightIdUserEmail(String email);
	
}
