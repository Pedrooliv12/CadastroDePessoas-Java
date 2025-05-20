package dev.oliveira.DevTask.Users;

import dev.oliveira.DevTask.Projetos.TaskModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
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
    @JoinColumn(name = "Tasks_id") // Chave estrangeira
    private TaskModel tasks;

    public UserModel() {}

    public UserModel(String nome, String email, int idade, Boolean status) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
