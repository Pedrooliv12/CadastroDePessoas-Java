package dev.oliveira.DevTask.Projetos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.oliveira.DevTask.Users.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "tb_tasks")
@NoArgsConstructor
@Getter
@Setter
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean finish;

    // @OneToMany - Uma task pode ter varios devs(users)
    @OneToMany(mappedBy = "task")
    @JsonIgnoreProperties({"email", "idade", "task"})
    private List<UserModel> users;

    public TaskModel(String nome, Boolean finish) {
        this.nome = nome;
        this.finish = finish;
    }

}
