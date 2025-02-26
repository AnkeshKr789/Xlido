package com.crio.xlido.repositories;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.crio.xlido.entities.Question;

public class QuestionRepository implements IQuestionRepository {
    private final Map<Integer, Question> questionsMap = new HashMap<>();
    private int questionId = 1;

    public Question save(String content, int eventId, int userId) {
        Question question = new Question(questionId,content, eventId, userId);
        questionsMap.put(questionId, question);
        questionId++;
        return question;
    }

    public Optional<Question> findById(int id) {
        return Optional.ofNullable(questionsMap.get(id));
    }

    public boolean questionExist(int id){
        return questionsMap.containsKey(id);
    }

    public List<Question> findAll() {
        return new ArrayList<>(questionsMap.values());
    }

    public void deleteById(int id) {
        questionsMap.remove(id);
    }

    public boolean isAuthor(int id, int user_id) {
        return questionsMap.get(id).getUser_id() == user_id;
    }

    public boolean hasUserUpvoted(int questionId, int userId) {
        return questionsMap.get(questionId).hasUserUpvoted(userId);
    }

    public void upvoteQuestion(int questionId, int userId) {
        questionsMap.get(questionId).getUpvote(userId);
    }

    public void addReply(String reply, int questionId, int user_id){
        Question question = questionsMap.get(questionId);
        question.addReply(user_id,reply);
    }

    @Override
    public List<Question> findByEventId(int eventId, String sortBy) {
        List<Question> questions = new ArrayList<>();
        for(Question question: questionsMap.values()){
            if(question.getEvent_id() == eventId){
                questions.add(question);
            }
        }

        if(sortBy.equals("POPULAR")){
            Collections.sort(questions, new Comparator<Question>() {
                public int compare(Question q1, Question q2){
                    return Integer.compare(q2.getUpvoteCount(), q1.getUpvoteCount());
            }
            });
        }

        else if(sortBy.equals("RECENT")){
            Collections.sort(questions, new Comparator<Question>() {
                public int compare(Question q1, Question q2){
                    return Integer.compare(q2.getId(), q1.getId());
            }
            });
        }
        return questions;
    }
    
}
