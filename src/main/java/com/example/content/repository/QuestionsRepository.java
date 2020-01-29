package com.example.content.repository;


import com.example.content.document.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionsRepository extends MongoRepository<Questions,String> {
}
