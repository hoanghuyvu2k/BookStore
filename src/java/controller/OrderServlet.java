package controller;

import dao.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class OrderServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>CartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        } 
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("customerID") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int customerId = (int) session.getAttribute("customerID");
        CartDAO cartDAO = new CartDAO();
        try {
            request.setAttribute("cartItem", cartDAO.showCartItems(customerId, 0));
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rs = request.getRequestDispatcher("cart.jsp");
        rs.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("deleteButton");
        CartDAO cartDAO = new CartDAO();
        if (button != null && request.getParameter("cartItemId") != null) {
            try {
                int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
                cartDAO.deleteCartItem(cartItemId);
            } catch (SQLException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        HttpSession session = request.getSession();
        if (session.getAttribute("customerID") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int customerId = (int) session.getAttribute("customerID");
        
        String paymentMethod = request.getParameter("paymentMethods");
        String shipmentMethod = request.getParameter("shipmentMethods");
        if (paymentMethod != null && shipmentMethod != null) {
            String cartIdArr = request.getParameter("cartIdArr");
            float sumPrice = Float.parseFloat(request.getParameter("sumPrice"));
            
            if (sumPrice == 0.0) {
                return;
            }
            if (shipmentMethod == "1") {
                sumPrice += 15000;
            } else {
                sumPrice += 10000;
            }
            
            try {
                cartDAO.updateBoughtCartItem(cartIdArr);
                cartDAO.createOrder(customerId, Integer.parseInt(paymentMethod), Integer.parseInt(shipmentMethod), sumPrice, cartIdArr);
            } catch (SQLException ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("sumPrice", sumPrice);
            RequestDispatcher rs = request.getRequestDispatcher("ordersuccess.jsp");
            rs.forward(request, response);
            return;
        }
        
        try {
            request.setAttribute("cartItem", cartDAO.showCartItems(customerId, 0));
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rs = request.getRequestDispatcher("cart.jsp");
        rs.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}