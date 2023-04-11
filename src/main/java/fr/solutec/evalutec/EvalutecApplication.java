package fr.solutec.evalutec;

import fr.solutec.evalutec.models.Answer;
import fr.solutec.evalutec.models.Question;
import fr.solutec.evalutec.models.Topic;
import fr.solutec.evalutec.repositories.AnswerRepository;
import fr.solutec.evalutec.repositories.QuestionRepository;
import fr.solutec.evalutec.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        System.out.println("done");
    }
}
