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
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    String comparação;
    Vendas teste = new Vendas();

    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
   

   
    
    public void venderProdutos(){
       
        
       
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
  
    public void listarProdutosVendidos(){
        conectaDAO i = new conectaDAO();
        Connection conn = i.connectDB();
        
        DefaultTableModel tableModel = (DefaultTableModel)teste.tabela.getModel();
        
        try{
        String listar = "select * from produtos where id = ?";
        PreparedStatement ps = conn.prepareStatement(listar);
        ps.setString(1, comparação);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          int id = rs.getInt("id"); 
          String nome = rs.getString("nome");
          int valor = rs.getInt("valor");
          String status = rs.getString("status");
          
          Object[] dados = {id, nome, valor, status};
        tableModel.addRow(dados);  
        }
        }catch(SQLException sqle){
            System.out.println("Erro ao inserir produto: " + sqle.getMessage());
        }
      
}



        
}



