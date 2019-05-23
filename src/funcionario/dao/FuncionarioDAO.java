package funcionario.dao;

import banco.Conexao;
import funcionario.model.Funcionario;
import produto.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public static void save(Funcionario funcionario){
        String sql = "INSERT INTO funcionario(nome, preco, desconto) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

//            pstm.setString(1, produto.getNome());
//            pstm.setFloat(2, produto.getPreco());
//            pstm.setInt(3, produto.getDesconto());

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

    public static Produto getById(Integer id){
//        String sql = "select * FROM produto WHERE id = ?";
        Produto produto = new Produto();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;
        try {
            conn = Conexao.createConnectionToMySQL();
//            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            while (rset.next()){
//                produto.setId(rset.getInt("id"));
//                produto.setNome(rset.getString("nome"));
//                produto.setPreco(rset.getFloat("preco"));
//                produto.setDesconto(rset.getInt("desconto"));
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
        return produto;
    }

    public static void removeById(int id){
        String sql = "DELETE FROM produto WHERE id = ?";
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

    public static List<Produto> getProdutos(){

        String sql = "SELECT * FROM produto order by id";
        List<Produto> produtos = new ArrayList<Produto>();
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
                Produto produto = new Produto();
                produto.setId(rset.getInt("id"));
                produto.setNome(rset.getString("nome"));
                produto.setPreco(rset.getFloat("preco"));
                produto.setDesconto(rset.getInt("desconto"));
                produtos.add(produto);
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
        return produtos;
    }

    public static void updateProduto(Produto produto){
        String sql = "UPDATE produto SET nome = ?, preco = ?, desconto = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setFloat(2, produto.getPreco());
            pstm.setInt(3, produto.getDesconto());
            pstm.setInt(4, produto.getId());
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
