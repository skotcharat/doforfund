package com.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Response1{


	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}

	@Override
 	public String toString(){
		return 
			"Response1{" + 
			"postalCodes = '" + postalCodes + '\'' + 
			"}";
		}
}