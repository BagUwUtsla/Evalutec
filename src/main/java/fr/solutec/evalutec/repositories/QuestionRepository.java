package fr.solutec.evalutec.repositories;

import fr.solutec.evalutec.models.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository  extends CrudRepository<Question, Long> {
    @Query("SELECT q FROM Question q JOIN Topic t WHERE t.id = ?1")
    public List<Question> findByTopicId(Long id);

    @Query("SELECT q FROM Question q JOIN Topic t WHERE t.id = ?1 AND q.difficulty = ?2")
    public List<Question> findByTopicIdAndDifficulty(Long idTopic, String difficulty);
}
