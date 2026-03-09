package com.ui.pojo;

// store the Keys url in the environment variable
public class Environment {
	
	//for Json file
    private String url;
    private int MAX_NO_ATTEMPTS; 

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMAX_NO_ATTEMPTS() {
		return MAX_NO_ATTEMPTS;
	}

	public void setMAX_NO_ATTEMPTS(int mAX_NO_ATTEMPTS) {
		MAX_NO_ATTEMPTS = mAX_NO_ATTEMPTS;
	}
}

