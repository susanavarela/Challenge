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
	"name",
	"catchPhrase",
	"bs"
})
public class CompanyDto {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("catchPhrase")
	private String catchPhrase;
	
	@JsonProperty("bs")
	private String bs;
	
}