/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */


import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    Statement stmt;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException{        
        String sql = "insert into produtos values (?,?,?)";
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());        
        
        prep.executeUpdate();
        
        try {
            conn.close();
            System.out.println( "Conexão com o banco de dados fechada" );
        } catch (SQLException sqle) {
            System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage());
        }
                
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException{
        String sql = "select * from produtos";
        stmt = conn.createStatement();
        resultset = stmt.executeQuery(sql);
        while (resultset.next()){
            int id = resultset.getInt("id");
            String nome = resultset.getString("nome");
            int valor = resultset.getInt("valor");
            String status = resultset.getString("status");
            
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(id);
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setStatus(status);
            
            listagem.add(produto);
        }
        try {
            conn.close();
            System.out.println( "Conexão com o banco de dados fechada" );
        } catch (SQLException sqle) {
            System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage());
        }
        return listagem;
    }
    public void venderProduto(){
        
    }
    public ArrayList<ProdutosDTO> listaProdutosVendidos(){
        
        return listagem;
    }
    
    
        
}

