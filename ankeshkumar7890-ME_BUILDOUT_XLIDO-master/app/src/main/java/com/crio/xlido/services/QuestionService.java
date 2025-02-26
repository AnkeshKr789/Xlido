package com.crio.xlido.services;

import java.util.List;
import com.crio.xlido.entities.Question;
import com.crio.xlido.repositories.IEventRepository;
import com.crio.xlido.repositories.IQuestionRepository;
import com.crio.xlido.repositories.IUserRepository;

public class QuestionService {
    private final IQuestionRepository questionRepository;
    private final IUserRepository userRepository;
    private final IEventRepository eventRepository;

    public QuestionService(IQuestionRepository questionRepository, IUserRepository userRepository,
            IEventRepository eventRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public String addQuestion(String content, int event_id, int user_id){
        if(!userRepository.userExist(user_id)){
            return "ERROR: User with an id "+ user_id + " does not exist";
        }

        if(!eventRepository.eventExists(event_id)) {
            return "ERROR: Event with an id " + event_id + " does not exist";
        }
        Question question = questionRepository.save(content, event_id, user_id);
        return "Question ID: "+ question.getId();
    }

    public String deleteQuestion(int id, int user_id){
        if(!userRepository.userExist(user_id)){
            return "ERROR: User with an id "+ user_id + " does not exist";
        }

        if (!questionRepository.questionExist(id)){
            return "ERROR: Question with an id "+ id + " does not exist";
        }

        if(!questionRepository.isAuthor(id, user_id)){
            return "ERROR: User with an id "+ user_id + " is not an author of question with an id "+ id;
        }

        questionRepository.deleteById(id);
        return "QUESTION_DELETED "+id;
    }

    public String upvoteQuestion(int questionId, int userId) {
        if (!userRepository.userExist(userId)) {
            return "ERROR: User with an id " + userId + " does not exist";
        }
    
        if (!questionRepository.questionExist(questionId)) {
            return "ERROR: Question with an id " + questionId + " does not exist";
        }

        if(questionRepository.hasUserUpvoted(questionId, userId)){
            return "ERROR: User with an id "+ userId + " has already upvoted a question with an id "+ questionId;
        }
    
        questionRepository.upvoteQuestion(questionId, userId);
        return "QUESTION_UPVOTED " + questionId;
    }

    public String replyQuestion(String reply, int questionId, int userId){
        if(!userRepository.userExist(userId)){
            return "ERROR: User with an id " + userId + " does not exist";
        }

        if (!questionRepository.questionExist(questionId)) {
            return "ERROR: Question with an id " + questionId + " does not exist";
        }

        questionRepository.addReply(reply, questionId, userId);
        return "REPLY_ADDED";
    }

    public String listQuestions(int eventId, String sortBy) {
        if (!eventRepository.eventExists(eventId)) {
            return "ERROR: Event with an id " + eventId + " does not exist\n";
        }

        List<Question> questions = questionRepository.findByEventId(eventId, sortBy);
        StringBuilder output = new StringBuilder();
        for (Question q : questions) {
            output.append(q.toString()).append("\n");
        }

        return output.toString();
    } 
    
}
