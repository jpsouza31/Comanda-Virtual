package banco;

import java.sql.*;

public class Conexao {
    //Nome do usuário do mysql
    private static final String USERNAME = "postgres";

    //Senha do mysql
    private static final String PASSWORD = "admin";

    //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/comandavirtual";
    public static Connection createConnectionToMySQL() throws Exception{
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }
    public static void main(String[] args) throws Exception{

        //Recupera uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //Testa se a conexão é nula
        if(con != null){
            System.out.println("Conexão obtida com sucesso!" + con);
            con.close();
        }

    }
}




