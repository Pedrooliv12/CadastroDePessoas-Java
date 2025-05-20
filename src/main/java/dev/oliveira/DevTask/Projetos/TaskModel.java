package dev.oliveira.DevTask.Projetos;

import dev.oliveira.DevTask.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
    private Boolean pending;

    // @OneToMany - Uma task pode ter varios devs(users)
    @OneToMany(mappedBy = "task")
    private List<UserModel> users;

    public TaskModel(String nome, Boolean pending) {
        this.nome = nome;
        this.pending = pending;
    }

}
