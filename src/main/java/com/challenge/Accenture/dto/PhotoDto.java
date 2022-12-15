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
	"albumId",
	"id",
	"title",
	"url",
	"thumbnailUrl"
})
public class PhotoDto {

	@JsonProperty("albumId")
	private int albumId;
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("thumbnailUrl")
	private String thumbnailUrl;
	
}