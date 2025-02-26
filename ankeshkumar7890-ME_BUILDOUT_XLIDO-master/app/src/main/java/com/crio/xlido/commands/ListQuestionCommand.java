package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.services.QuestionService;

public class ListQuestionCommand implements ICommand{
    private QuestionService questionService;

    public ListQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        int event_id = Integer.parseInt(tokens.get(1));
        String sortBy = tokens.get(2);
        System.out.print(questionService.listQuestions(event_id, sortBy));
    }

}
