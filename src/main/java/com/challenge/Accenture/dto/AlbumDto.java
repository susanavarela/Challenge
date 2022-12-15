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
	"userId",
	"id",
	"title"
})
public class AlbumDto {

	@JsonProperty("userId")
	private Integer userId; 

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("title")
	private String title;


}