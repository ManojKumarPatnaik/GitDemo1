package com.automation.id.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePojo {
	
	@JsonProperty("CreateProfileResult")
	private CreateProfileResult createProfileResult;

	public CreateProfileResult getCreateProfileResult() {
		return createProfileResult;
	}

	public void setCreateProfileResult(CreateProfileResult createProfileResult) {
		this.createProfileResult = createProfileResult;
	}
	
}
