package com.emergency.system.services.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import com.emergency.system.entities.DatabaseSequence;
import com.emergency.system.services.ISequenceGeneratorService;

public class SequenceGeneratorServiceImpl implements ISequenceGeneratorService{
	
	@Autowired
	private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {

        DatabaseSequence counter = this.mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}
