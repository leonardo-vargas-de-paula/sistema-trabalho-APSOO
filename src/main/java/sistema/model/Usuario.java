package sistema.model;

import jakarta.persistence.*;
@Entity
public class Usuario {
    @Id
    private String id;
    private String senha;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Funcionario funcionario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
