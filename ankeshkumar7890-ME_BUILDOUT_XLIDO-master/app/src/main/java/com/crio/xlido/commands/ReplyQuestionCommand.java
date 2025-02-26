package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.QuestionService;

public class ReplyQuestionCommand implements ICommand{

    private final QuestionService questionService;
    
    public ReplyQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String content = tokens.get(1);
        int questionId = Integer.parseInt(tokens.get(2));
        int user_id = Integer.parseInt(tokens.get(3));
        System.out.println(questionService.replyQuestion(content, questionId, user_id));
        
    }
    
}
