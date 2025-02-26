package com.crio.xlido.repositories;

import java.util.Optional;
import java.util.List;
import com.crio.xlido.entities.Question;

public interface IQuestionRepository {
    Question save(String content, int eventId, int userId);
    Optional<Question> findById(int id);
    List<Question> findAll();
    void deleteById(int id);
    boolean questionExist(int id);
    boolean isAuthor(int id, int user_id);
    boolean hasUserUpvoted(int questionId, int userId);
    void upvoteQuestion(int questionId, int userId);
    void addReply(String reply, int questionId, int user_id);
    public List<Question> findByEventId(int eventId, String sortBy);
}
