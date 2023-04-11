package fr.solutec.evalutec.services;

import fr.solutec.evalutec.models.Question;
import fr.solutec.evalutec.repositories.QuestionRepository;
import fr.solutec.evalutec.repositories.TopicRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Service
public class GenerateQuizService {
    private final TopicRepository topicRepository;
    private final QuestionRepository questionRepository;
    @Autowired
    public GenerateQuizService(TopicRepository topicRepository, QuestionRepository questionRepository){
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionsByTopicId(Long idTopic){
        List<Question> beginnerQuestionsList = getQuestionByTopicIdAndDifficulty(idTopic, "beginner");
        List<Question> confirmedQuestionsList = getQuestionByTopicIdAndDifficulty(idTopic, "confirmed");
        List<Question> expertQuestionsList = getQuestionByTopicIdAndDifficulty(idTopic, "expert");
        return null;
    }

    public List<Question> getQuestionByTopicIdAndDifficulty(Long idTopic, String difficulty) {
        return questionRepository.findByTopicIdAndDifficulty(idTopic, difficulty);
    }

    public List<Question> getQuestionsSubList(int questionNumber, List<Question> questionList) {
        List<Question> questionsSubList = new ArrayList<>();
        List<Integer> alreadySelected = new ArrayList<>();
        Random r = new Random();
        int randomIndex;
        for (int i = 0; i < questionNumber; i++) {
            do {
                randomIndex = r.nextInt(questionList.size());
            } while (alreadySelected.contains(randomIndex));
            questionsSubList.add(questionList.get(randomIndex));
            alreadySelected.add(randomIndex);
        }
        return questionsSubList;
    }
}
