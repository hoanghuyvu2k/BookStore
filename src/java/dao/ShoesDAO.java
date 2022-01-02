/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clothes;
import model.Electronics;
import model.Shoes;

/**
 *
 * @author DELL
 */
public class ShoesDAO {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public ShoesDAO() {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/store?useSSL=false";
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("ket noi thanh con csdl");
        } catch (Exception e) {
            System.err.println("Khong ket noi duoc" + e.toString());
        }
    }
    public ArrayList<Shoes> getShoesNew() {
        String query = "SELECT * from shoes";
        ArrayList<Shoes> arr = new ArrayList<Shoes>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int inventory = rs.getInt("Inventory");
                String category = rs.getString("Category");
                float discount = rs.getFloat("Discount");
                Shoes shoes = new Shoes(id, name, price, inventory, category, discount);
                arr.add(shoes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public Shoes getShoesById(int id) {
        String query = "SELECT * FROM shoes WHERE id = " + id;
        Shoes shoes = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                int inventory = rs.getInt("Inventory");
                String category = rs.getString("Category");
                float discount = rs.getFloat("Discount");
                String description = rs.getString("Description");
                int size = rs.getInt("Size");
                String brand = rs.getString("Brand");
                String material = rs.getString("material");
                String color = rs.getString("Color");
                String type = rs.getString("Type");
                shoes = new Shoes(id, name, price, inventory, description, size, brand, material, color, category, type, discount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shoes;
    }
    
    public void deleteShoes(int shoesId) throws SQLException {
        String query = "DELETE FROM shoes WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, shoesId);
        ps.executeUpdate();
    }
    
    public void addShoes(String name, float price, String category, String color, String material, int inventory, float discount, String description,
             int size, String brand, String type) throws SQLException {
        String addBook = "INSERT INTO shoes (Name, Price, Category, Color, Material, Inventory, Discount, Description, Size, Brand, Type) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps3 = connection.prepareStatement(addBook);
        ps3.setString(1, name);
        ps3.setFloat(2, price);
        ps3.setString(3, category);
        ps3.setString(4, color);
        ps3.setString(5, material);
        ps3.setInt(6, inventory);
        ps3.setFloat(7, discount);
        ps3.setString(8, description);
        ps3.setInt(9, size);
        ps3.setString(10, brand);
        ps3.setString(11, type);
        ps3.executeUpdate();
    }
    
    public void changeShoes(int id, String name, float price, String category, String color, String material, int inventory, float discount, String description,
             int size, String brand, String type) throws SQLException {
        String updateShoes = "UPDATE shoes SET Name = ?, Price= ?, Category= ?, Color= ?, Material= ?, Inventory= ?, Discount= ?, Description= ?, Size= ?, Brand= ?, Type= ? WHERE id = ?";
        PreparedStatement ps3 = connection.prepareStatement(updateShoes);
        ps3.setString(1, name);
        ps3.setFloat(2, price);
        ps3.setString(3, category);
        ps3.setString(4, color);
        ps3.setString(5, material);
        ps3.setInt(6, inventory);
        ps3.setFloat(7, discount);
        ps3.setString(8, description);
        ps3.setInt(9, size);
        ps3.setString(10, brand);
        ps3.setString(11, type);
        ps3.setInt(12, id);
        ps3.executeUpdate();
    }
}
