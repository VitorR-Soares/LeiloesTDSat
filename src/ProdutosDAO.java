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
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
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
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        
        
        return listagem;
    }
    
    
    
        
}

