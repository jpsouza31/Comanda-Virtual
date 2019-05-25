package funcionario.dao;

import banco.Conexao;
import funcionario.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public static void save(Funcionario funcionario){
        String sql = "INSERT INTO funcionario(nome, email, login, senha, cpf) VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();
            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getEmail());
            pstm.setString(3, funcionario.getLogin());
            pstm.setInt(4, funcionario.getSenha());
            pstm.setString(5, funcionario.getCpf());

            //Executa a sql para inserção dos dados
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){ pstm.close(); }
                if(conn != null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Funcionario getById(Integer id){
        String sql = "select * FROM funcionario WHERE id = ?";
        Funcionario funcionario = new Funcionario();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            while (rset.next()){
                funcionario.setId(rset.getInt("id"));
                funcionario.setNome(rset.getString("nome"));
                funcionario.setEmail(rset.getString("email"));
                funcionario.setCpf(rset.getString("cpf"));
                funcionario.setLogin(rset.getString("login"));
                funcionario.setSenha(rset.getInt("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(rset != null){ rset.close(); }
                if(pstm != null){ pstm.close(); }
                if(conn != null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return funcionario;
    }

    public static void removeById(int id){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){ pstm.close(); }
                if(conn != null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static List<Funcionario> getFuncionarios(){

        String sql = "SELECT * FROM funcionario order by id";
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rset.getInt("id"));
                funcionario.setNome(rset.getString("nome"));
                funcionario.setEmail(rset.getString("email"));
                funcionario.setCpf(rset.getString("cpf"));
                funcionario.setLogin(rset.getString("login"));
                funcionario.setSenha(rset.getInt("senha"));
                funcionarios.add(funcionario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(rset != null){ rset.close(); }
                if(pstm != null){ pstm.close(); }
                if(conn != null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return funcionarios;
    }

    public static void updateFuncionario(Funcionario funcionario){
        String sql = "UPDATE funcionario SET nome = ?, email = ?, login = ?, senha = ?, cpf = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getEmail());
            pstm.setString(3, funcionario.getLogin());
            pstm.setInt(4, funcionario.getSenha());
            pstm.setString(5, funcionario.getCpf());
            pstm.setInt(6, funcionario.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){ pstm.close(); }
                if(conn != null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
