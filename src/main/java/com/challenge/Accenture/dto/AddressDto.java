package com.challenge.Accenture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"street",
	"suite",
	"city",
	"zipcode",
	"geo"
})
public class AddressDto {

	@JsonProperty("street")
	private String street;
	
	@JsonProperty("suite")
	private String suite;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("zipcode")
	private String zipcode;
	
	@JsonProperty("geo")
	private GeoDto geo;
	

}