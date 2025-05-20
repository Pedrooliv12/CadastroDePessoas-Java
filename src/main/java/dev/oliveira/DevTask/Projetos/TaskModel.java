package dev.oliveira.DevTask.Projetos;

import dev.oliveira.DevTask.Users.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean pending;

    // @OneToMany - Uma task pode ter varios devs(users)
    @OneToMany(mappedBy = "tasks")
    private List<UserModel> users;

    public TaskModel() {}

    public TaskModel(String nome, Boolean pending) {
        this.nome = nome;
        this.pending = pending;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

}
