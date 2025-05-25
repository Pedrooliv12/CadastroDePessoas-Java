package dev.oliveira.DevTask.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.oliveira.DevTask.Projetos.TaskModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private Boolean status;

    // @ManyToOne - Um dev(user) tem apenas uma task
    @ManyToOne
    @JoinColumn(name = "task_id") // Chave estrangeira
    private TaskModel task;

    public UserModel(String nome, String email, int idade, Boolean status) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.status = status;
    }

}
