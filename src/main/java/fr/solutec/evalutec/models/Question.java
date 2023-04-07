package fr.solutec.evalutec.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Question {
    @Id @GeneratedValue
    private Long id;
    private String difficulty;
    private String intitule;
    @OneToMany
    private List<Answer> answers;
    private int value;
}

@Entity
class Answer{
    @Id
    private Long id;
    private String text;
    private boolean rightAnswer;
}
