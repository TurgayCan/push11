package com.push11.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "application_tag")
public class ApplicationTag extends AbstractDocument{

	private static final long serialVersionUID = -3715874836188536271L;

	private Application application;

	private List<String> tagList;

	public ApplicationTag() {
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

}
