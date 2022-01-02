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
//import model.Sach;
//import model.Taikhoan;

import model.Account;
import model.Address;
import model.Customer;
import model.Fullname;

public class CustomerDAO {
	private Connection connection;
    private Statement st;
    private ResultSet rs;

    public CustomerDAO() {
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
    public boolean checkExistedAccount(Account account){
        boolean result = false;
        String sqlCheck = "Select * from account where Name = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ps.setString(1, account.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public void addCustomer(Customer customer) {
        String sqlAddCus = "INSERT INTO customer(Email) VALUE(?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlAddCus, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getEmail());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addFullname(Fullname fullname, Customer customer){
        String sqlAddFullname = "INSERT INTO fullname(CustomerID, Firstname, Middlename, Lastname) VALUE(?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlAddFullname, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customer.getId());
            ps.setString(2, fullname.getFirstName());
            ps.setString(3, fullname.getMiddleName());
            ps.setString(4, fullname.getLastName());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                fullname.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addAccount(Account account, Customer customer){
        String sqlRegister = "INSERT INTO account(CustomerID, Name, Password) VALUE(?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlRegister, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customer.getId());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                account.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addAddress(Address address, Customer customer){
        String sqlAddAddress = "INSERT INTO address(CustomerID, Commune, City, District) VALUE(?, ?, ?, ?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlAddAddress, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customer.getId());
            ps.setString(2, address.getCommune());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getDistrict());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                address.setId(generatedKeys.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int checkLogin(Account account) {
        try {
            String query = "SELECT * FROM account WHERE Name = ? AND Password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("CustomerID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    } 
}
