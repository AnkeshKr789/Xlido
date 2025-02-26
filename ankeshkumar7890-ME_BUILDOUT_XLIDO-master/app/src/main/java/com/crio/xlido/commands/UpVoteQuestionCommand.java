package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.QuestionService;

public class UpVoteQuestionCommand implements ICommand{

    private final QuestionService questionService;

    public UpVoteQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        int question_id = Integer.parseInt(tokens.get(1));
        int user_id = Integer.parseInt(tokens.get(2));
        System.out.println(questionService.upvoteQuestion(question_id, user_id));
    }
    
}
