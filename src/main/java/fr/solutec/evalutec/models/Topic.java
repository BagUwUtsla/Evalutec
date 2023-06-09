package fr.solutec.evalutec.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Topic {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<Question> questions;

}
