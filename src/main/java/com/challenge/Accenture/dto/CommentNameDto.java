package com.challenge.Accenture.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
public class CommentNameDto {

	@JsonProperty("name")
	private String name;
	
}
