package fr.solutec.evalutec;

import fr.solutec.evalutec.models.Answer;
import fr.solutec.evalutec.models.Question;
import fr.solutec.evalutec.models.Topic;
import fr.solutec.evalutec.repositories.AnswerRepository;
import fr.solutec.evalutec.repositories.QuestionRepository;
import fr.solutec.evalutec.repositories.TopicRepository;
import jakarta.websocket.Decoder.Text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.Arrays;

@SpringBootApplication
public class EvalutecApplication implements CommandLineRunner {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TopicRepository topicRepository;


    public static void main(String[] args) {
        SpringApplication.run(EvalutecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Answer a1 = new Answer(null, "5", true);
        Question q1 = new Question(null, "expert", "2+3", Arrays.asList(a1), 4);
        Topic t1 = new Topic(null, "Python", "c'est un serpent", Arrays.asList(q1));
        answerRepository.save(a1);
        questionRepository.save(q1);
        topicRepository.save(t1);

        Answer answer1 = new Answer(null, "console.print(text)", false);
        Answer answer2 = new Answer(null,"print(text)", true);
        Answer answer3 = new Answer(null,"System.out.println(text)", false);
        Answer answer4 = new Answer(null,"console.log(text)", false);
        Question question1 = new Question(null,"Facile", "Impression de texte", Arrays.asList(answer1, answer2, answer3, answer4), 1);
        answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);
        answerRepository.save(answer4);
        questionRepository.save(question1);

        System.out.println("done");
    }
}
