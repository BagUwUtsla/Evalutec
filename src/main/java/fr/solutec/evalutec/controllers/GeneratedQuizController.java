package fr.solutec.evalutec.controllers;

import fr.solutec.evalutec.models.Question;
import fr.solutec.evalutec.services.GenerateQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("GenerateTopic")
public class GeneratedQuizController {
    @Autowired
    private GenerateQuizService generateQuizService;

    @GetMapping("/{idTopic}")
    public List<Question> getQuestionsByTopic(@PathVariable Long idTopic){
        return generateQuizService.getQuestionsByTopicId(idTopic);
    }
}
