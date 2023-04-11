package fr.solutec.evalutec.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Answer{
    @Id @GeneratedValue
    private Long id;
    private String text;
    private boolean rightAnswer;
}
