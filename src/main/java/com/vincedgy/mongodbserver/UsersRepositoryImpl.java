package com.vincedgy.mongodbserver;

import com.mongodb.client.result.UpdateResult;
import com.vincedgy.mongodbserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UsersRepositoryImpl implements UsersCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateUserByName(String name, String value) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("value", value);

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }
}
