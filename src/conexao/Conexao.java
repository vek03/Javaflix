package conexao;

//Classe especifica para conexão e comunicação com o banco 

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Victor Cardoso
 * Vek Histories
 */

public class Conexao 
{
    //aqui declaramos as variaveis que serão utilizadas como drivers, url, usuário, senha,
    //conexão, Statement e Resultset
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/bd_locadora";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    
    
    public boolean conecta(){
        //aqui utilizamos as variaveis de entrada para iniciar a conexão com o banco
        //Caso a conexão não tenha sucesso, exibe uma mensagem de erro ao usuário
        boolean result = true;
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);        
        } catch (ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null, "Driver não localizado.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }catch (SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada.", "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
    }
    
    public void desconecta(){
        //aqui nós iremos finalizar a conexão com o banco, caso seja chamada
        
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException fecha){
            
        }
    }
    
    public void executaSQL(String sql){
        //aqui iremos mandar os comandos SQL solicitados pelo usuário e feitas pelo programa para o banco,
        //modificando, salvando, trazendo ou deletando registros. Manipulando o banco
        
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException excecao){
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
            
}
