package com.jbritland.DTOs;

import java.sql.Date;

import com.jbritland.Entities.Weight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ResponseWeightDTO {

	private Date weighDate;
	private double weightKg;
	
	public static ResponseWeightDTO of(Weight weight) {
		return new ResponseWeightDTO(weight.getWeightId().getWeighDate(), weight.getWeightKg());
	}
	
}
