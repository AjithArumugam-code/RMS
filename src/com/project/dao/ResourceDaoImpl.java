package com.project.dao;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.project.common.MongoFactory;
import com.project.model.ResumeFile;

@Component
public class ResourceDaoImpl implements ResourceDao {
	private static Logger log = Logger.getLogger(ResourceDaoImpl.class);

	static String db_name = "db", db_collection = "RESUME_FILE";

	@Override
	public ResumeFile addPhoto(ResumeFile file) throws IOException {
		DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
		BasicDBObject doc = new BasicDBObject();
		doc.put("resume", file.getResume());
		coll.insert(doc);
		log.info(doc);
		return file;
	}
	


}
