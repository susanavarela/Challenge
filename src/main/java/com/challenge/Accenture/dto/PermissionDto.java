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
public class PermissionDto {

	@JsonProperty("user")
	private int user; 

	@JsonProperty("album")
	private int album;

	@JsonProperty("permissionType")
	private int permissionType;
	
	
}
