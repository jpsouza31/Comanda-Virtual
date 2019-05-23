package funcionario.model;

import pessoa.model.Pessoa;

public class Funcionario extends Pessoa {
    private String login;
    private Integer senha;

    public Funcionario(String login, Integer senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }
}
