package connDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Caiqu
 */
public class DB {

    private static Connection conn = null;
    private static Connection connAzure = null;
    Statement stmt = null;
    PreparedStatement prepstmt = null;

    public static Connection getConexaoMySQL() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://ContainerBD:3306/containertreino?useTimezone=true&serverTimezone=UTC";
                String user = "root";
                String password = "urubu100";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida no mySQL com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar-se ao banco de dados");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC não encontrado");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static Connection getConexaoSqlServer() throws IOException {
        if (connAzure == null) {
            try {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String url = "jdbc:sqlserver://svr-medserver-sentinel.database.windows.net:1433;databaseName=bd-medserver-sentinel";
               String user = "admin-medserver-sentinel";
               String password = "#Gfgrupo4";
               connAzure = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida na Azure com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar-se ao banco de dados");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC não encontrado");
                e.printStackTrace();
            }
        }
        return connAzure;
    }

    public void createTable() throws IOException {
        try {
            Connection conn = DB.getConexaoMySQL();
            Connection connAzure = DB.getConexaoSqlServer();
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Usuario (id_usuario INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(45), "
                    + "email VARCHAR(45), senha VARCHAR(45), cpf VARCHAR(45), fkEmpresa INT, tipo VARCHAR(45));";
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso no mySQL");

            stmt = connAzure.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso no SqlServer!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela");
        }
    }

    public void insertUsuario(String nome, String email, String senha, String cpf, String tipo) throws IOException {
        try {
            Connection conn = DB.getConexaoMySQL();
            Connection connAzure = DB.getConexaoSqlServer();
            String sql = "INSERT INTO Usuario (nome,email,senha,cpf,tipo) VALUES(?,?,?,?,?)";
            prepstmt = conn.prepareStatement(sql);
            prepstmt.setString(1, nome);
            prepstmt.setString(2, email);
            prepstmt.setString(3, senha);
            prepstmt.setString(4, cpf);
            prepstmt.setString(5, tipo);
            prepstmt.executeUpdate();
            System.out.println("INSERT EXECUTADO COM SUCESSO NO MYSQL!");

            prepstmt = connAzure.prepareStatement(sql);
            prepstmt.setString(1, nome);
            prepstmt.setString(2, email);
            prepstmt.setString(3, senha);
            prepstmt.setString(4, cpf);
            prepstmt.setString(5, tipo);
            prepstmt.executeUpdate();
            System.out.println("INSERT EXECUTADO COM SUCESSO NA AZURE!");
        } catch (SQLException e) {
            System.out.println("Erro ao executar o INSERT");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
