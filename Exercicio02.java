package ExerciciosLista4;

/*
Caso de Uso 2: Conexão com Banco de Dados

Você está desenvolvendo uma aplicação que se conecta a um banco de dados PostgreSQL para buscar dados de uma tabela. Se a conexão com o banco de dados falhar, deve ser lançada uma exceção personalizada `DatabaseConnectionException`. Se a consulta SQL falhar, deve ser lançada uma exceção personalizada `SQLQueryException`.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Erros de conexão com o banco de dados
class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String message) {
        super(message);
    }
}

//Erros na consulta SQL (Query)
class SQLQueryException extends Exception {
    public SQLQueryException(String message) {
        super(message);
    }
}

public class Exercicio02 {
    public static void main(String[] args) throws DatabaseConnectionException, SQLQueryException {
            String url = "jdbc:postgresql://localhost:5432/banco";
            String user = "user_usuario";
            String password = "user_senha";

            Connection conexao = null;
            Statement statement = null;
            ResultSet resultSet = null;

        try{
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

            statement = conexao.createStatement();
            String query = "SELECT * FROM tabela";
            resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String matricula = resultSet.getString("matricula");
                System.out.println("ID: " + id + "Nome: " + nome + "E-mail: " + email + "Matrícula: " + matricula);
            }
            System.out.println("Consulta executada com sucesso!");

            resultSet.close();
            statement.close();
            conexao.close();
        }   catch (SQLException e) {
            if (e.getSQLState().equals("08001")) {
                try {
                    throw new DatabaseConnectionException("Erro de conexão com o banco de dados: " + e.getMessage());
                } catch (DatabaseConnectionException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    throw new SQLQueryException("Erro na consulta SQL: " + e.getMessage());
                } catch (SQLQueryException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }

    }
}
