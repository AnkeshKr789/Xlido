package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.QuestionService;

public class AddQuestionCommand implements ICommand {
    private final QuestionService questionService;
    

    public AddQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public void invoke(List<String> tokens) {
        String content = tokens.get(1);
        int user_id = Integer.parseInt(tokens.get(2));
        int event_id = Integer.parseInt(tokens.get(3));
        System.out.println(questionService.addQuestion(content, event_id, user_id));
    }
    
}
