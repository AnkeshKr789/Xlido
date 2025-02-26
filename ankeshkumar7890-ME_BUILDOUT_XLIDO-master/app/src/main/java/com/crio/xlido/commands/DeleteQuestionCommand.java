package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.QuestionService;

public class DeleteQuestionCommand implements ICommand {
    private final QuestionService questionService;

    public DeleteQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(1));
        int user_id = Integer.parseInt(tokens.get(2));
        System.out.println(questionService.deleteQuestion(id, user_id));
    }
    
}
