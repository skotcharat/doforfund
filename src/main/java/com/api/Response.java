package com.api;

import java.util.List;

public class Response{
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
			"Response{" + 
			"postalCodes = '" + postalCodes + '\'' + 
			"}";
		}
}