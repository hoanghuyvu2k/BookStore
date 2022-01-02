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
import model.Order;
import model.Book;
import model.Account;
import model.Cart;
import model.Customer;
import model.Payment;
import model.Shipment;

public class CartDAO {
	private Connection connection;
    private Statement st;
    private ResultSet rs;

    public CartDAO() {
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
    
    public void addItemToCart(int itemId, int customerId, float price, String name, String productName) throws SQLException {
        String queryFindAddedItem = "SELECT * FROM cart WHERE ItemId = ? AND CustomerId = ? AND ItemType = ?  AND bought = ?";
        PreparedStatement ps = connection.prepareStatement(queryFindAddedItem);
        ps.setInt(1, itemId);
        ps.setInt(2, customerId);
        ps.setString(3, name);
        ps.setInt(4, 0);
        ResultSet rs = ps.executeQuery();
        int amount = 0;
        float totalPrice = 0;
        int cartId = -1;
        while (rs.next()) {
            cartId = rs.getInt("id");
            amount = rs.getInt("Amount");
            totalPrice = rs.getFloat("TotalPrice");
        }
        
        if (cartId > 0) {
            String queryUpdate = "UPDATE cart SET Amount = ?, TotalPrice = ? WHERE id = ? and bought = ?";
            ps = connection.prepareStatement(queryUpdate);
            ps.setInt(1, amount+1);
            ps.setFloat(2, totalPrice+price);
            ps.setInt(3, cartId);
            ps.setInt(4, 0);
            ps.executeUpdate();
        } else {
            String queryUpdate = "INSERT INTO cart (ItemId, CustomerId, Amount, TotalPrice, ItemType, productName, bought) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(queryUpdate);
            ps.setInt(1, itemId);
            ps.setInt(2, customerId);
            ps.setInt(3, 1);
            ps.setFloat(4, price);
            ps.setString(5, name);
            ps.setString(6, productName);
            ps.setInt(7, 0);
            ps.executeUpdate();
        }
    }
    
    public ArrayList<Cart> showCartItems(int customerId, int option) throws SQLException {
        String query = null;
        if (option==1) {
            query = "SELECT * FROM cart WHERE bought = ?";
        } else {
            query = "SELECT * FROM cart WHERE CustomerId = ? AND bought = ?";
        } 
        PreparedStatement ps = connection.prepareStatement(query);
        if (option==1) {
            ps.setInt(1, option);
        } else {
            ps.setInt(1, customerId);
            ps.setInt(2, option);
        }
        ResultSet rs = ps.executeQuery();
        ArrayList<Cart> arr = new ArrayList<Cart>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String productName = rs.getString("ProductName");
            float price = rs.getFloat("TotalPrice");
            int amount = rs.getInt("Amount");
            String ItemType = rs.getString("ItemType");
            int CustomerId = rs.getInt("CustomerId");
            Cart cartItem = new Cart(id, amount, price, ItemType, productName, CustomerId);
            arr.add(cartItem);
        }
        return arr;
    }
    
    public void deleteCartItem(int cartItemId) throws SQLException {
        String query = "DELETE FROM cart WHERE id=?;";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, cartItemId);
        ps.executeUpdate();
    }
    
    public ArrayList<Payment> getPayemnts() throws SQLException {
        String query = "SELECT * FROM payment";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Payment> arr = new ArrayList<Payment>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String method = rs.getString("Method");
            Payment payment = new Payment(id, method);
            arr.add(payment);
        }
        return arr;
    } 
    
    public ArrayList<Shipment> getShipments() throws SQLException {
        String query = "SELECT * FROM shipment";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        ArrayList<Shipment> arr = new ArrayList<Shipment>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("Type");
            float price = rs.getFloat("Price");
            Shipment shipment = new Shipment(id, type, price);
            arr.add(shipment);
        }
        return arr;
    } 
    
    public void updateBoughtCartItem(String cartId) throws SQLException {
        String query = "UPDATE cart SET bought = 1 WHERE id IN "+cartId;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate();
    }
    
    public void createOrder(int customerId, int paymentId, int shipmentId, float totalPrice, String cartId) throws SQLException {
        String queryUpdate = "INSERT INTO orders (PaymentId, CustomerId, ShipmentId, CartId, TotalPrice) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(queryUpdate);
        ps.setInt(1, paymentId);
        ps.setInt(2, customerId);
        ps.setInt(3, shipmentId);
        ps.setString(4, cartId);
        ps.setFloat(5, totalPrice);
        System.out.println(ps);
        ps.executeUpdate();
    }
    
    public boolean addOrder(Order order, Customer customer) {
        try {
            String query = "SELECT MAX(id) as id FROM cart";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 1;
            while (rs.next()) {
                id = rs.getInt("id");
            }

            PreparedStatement ps;
            for (Book book : order.getListBook()) {
                String sql = "INSERT INTO cart (id,quantity, idBook) VALUES (?,1,?)";
                ps = connection.prepareStatement(sql);
                ps.setInt(1, id + 1);
                ps.setInt(2, book.getId());
                ps.executeUpdate();
                id++;
            }

            int total = 0;
            for (Book book : order.getListBook()) {
                total += book.getPrice();
            }
            /*
            String querySelect = "SELECT * FROM account WHERE username = ?";
            ps = connection.prepareStatement(querySelect);
            ps.setString(1, account.getUsername());
            rs = ps.executeQuery();
            int idCus = 1;
            while (rs.next()) {
                idCus = rs.getInt("id");
            }
            
            */
            
            String querySelect = "SELECT * FROM customer WHERE email = ? and phone = ?";
            ps = connection.prepareStatement(querySelect);
            ps.setString(1, customer.getEmail());
            ps.setString(2, customer.getPhone());
            System.out.print(ps);
            rs = ps.executeQuery();
            int idCus = 1;
            while (rs.next()) {
                idCus = rs.getInt("id");
            }
            
            for (Book book : order.getListBook()) {
            	String insertSQL = "INSERT INTO orderitem(totalPrice,idCustomer,idCart) VALUES (?,?,?)";
                ps = connection.prepareCall(insertSQL);
                ps.setInt(1, total);
                ps.setInt(2, idCus);
                ps.setInt(3, id - 1);
                System.out.print(ps);
                ps.executeUpdate();
                id--;
            }
            /*
            String insertSQL = "INSERT INTO orderitem(totalPrice,idCustomer,idCart) VALUES (?,?,?)";
            ps = connection.prepareCall(insertSQL);
            ps.setInt(1, total);
            ps.setInt(2, idCus);
            ps.setInt(3, id + 1);
            System.out.print(ps);
            ps.executeUpdate();
            */
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
