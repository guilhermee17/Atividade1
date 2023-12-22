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
    String comparação;
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    public void venderProdutos(){
        listagemVIEW l = new listagemVIEW();
        
       
        conectaDAO i = new conectaDAO();
        Connection conn = i.connectDB();
        try{
        String update = "update produtos set status = 'Vendido' where id = ?";
        PreparedStatement ps = conn.prepareStatement(update);
        ps.setString(1, comparação);
        
         ps.executeUpdate();
        System.out.println("Produto atualizado com sucesso");
        
          }catch(SQLException sqle ){
            System.out.println("Erro ao inserir produto: " + sqle.getMessage());
        }
    }
  
    


        
}

