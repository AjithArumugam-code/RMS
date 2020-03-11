package com.project.dao;

import java.io.IOException;

import com.project.model.ResumeFile;

public interface ResourceDao {

	ResumeFile addPhoto(ResumeFile file) throws IOException;

	String getId();

}
