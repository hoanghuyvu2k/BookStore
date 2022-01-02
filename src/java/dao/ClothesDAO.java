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
import model.Book;
import model.Clothes;
import model.Shoes;

/**
 *
 * @author DELL
 */
public class ClothesDAO {

    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public ClothesDAO() {
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

    public ArrayList<Clothes> getClothesNew() {
        String query = "SELECT * from clothes";
        ArrayList<Clothes> arr = new ArrayList<Clothes>();
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
                Clothes clothes = new Clothes(id, name, price, inventory, category, discount);
                arr.add(clothes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public Clothes getClothesById(int id) {
        String query = "SELECT * FROM clothes WHERE id = " + id;
        Clothes clothes = null;
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
                clothes = new Clothes(id, name, price, inventory, description, size, brand, material, color, category, discount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clothes;
    }

    public void deleteClothes(int clothesId) throws SQLException {
        String query = "DELETE FROM clothes WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, clothesId);
        ps.executeUpdate();
    }

    public void addClothes(String name, float price, String category, String color, String material, int inventory, float discount, String description,
             int size, String brand) throws SQLException {
        String addBook = "INSERT INTO clothes (Name, Price, Category, Color, Material, Inventory, Discount, Description, Size, Brand) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
        ps3.executeUpdate();
    }
    
    public void changeClothes(int id, String name, float price, String category, String color, String material, int inventory, float discount, String description,
             int size, String brand) throws SQLException {
        String updateClothes = "UPDATE clothes SET Name = ?, Price= ?, Category= ?, Color= ?, Material= ?, Inventory= ?, Discount= ?, Description= ?, Size= ?, Brand= ? WHERE id = ?";
        PreparedStatement ps3 = connection.prepareStatement(updateClothes);
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
        ps3.setInt(11, id);
        ps3.executeUpdate();
    }
}
