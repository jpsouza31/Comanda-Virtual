package funcionario.model;

import funcionario.dao.FuncionarioDAO;
import pessoa.model.Pessoa;

import java.util.List;

public class Funcionario extends Pessoa {
    private String login;
    private Integer senha;

    public void save(){
        try {
            FuncionarioDAO.save(this);
            System.out.println("Funcionário '"+ this.getNome() +"' inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(){
        try {
            FuncionarioDAO.updateFuncionario(this);
            System.out.println("Funcionário '"+ this.getNome() +"' atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(Integer id){
        try {
            FuncionarioDAO.removeById(Funcionario.findById(id).getId());
            System.out.println("Funcionário excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Funcionario findById(Integer id){
        return FuncionarioDAO.getById(id);
    }

    public static void listarFuncionarios(){
        List<Funcionario> funcionarios = FuncionarioDAO.getFuncionarios();
        if(funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado!");
        }else{
            System.out.println("ID        Nome        Email        CPF");
            for(Funcionario funcionario: funcionarios){
                System.out.println(funcionario.getId() +
                        "         " + funcionario.getNome() + "        " +
                        funcionario.getEmail() + "            " + funcionario.getCpf());
            }
        }
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
