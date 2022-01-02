package controller;

import dao.BookDAO;
import dao.CartDAO;
import dao.ElectronicsDAO;
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
import model.Order;
import model.Book;
import model.Customer;
import model.Account;
import model.Electronics;

@WebServlet("/Electronics")
public class ElectronicsServlet extends HttpServlet {
	/**
	 * 
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApprovalOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApprovalOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteButton = request.getParameter("deleteButton");
        String changeButton = request.getParameter("changeButton");
        HttpSession session = request.getSession();
        if (session.getAttribute("customerID") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        ElectronicsDAO electronicsDAO = new ElectronicsDAO();
        int itemId = -1;
        if (request.getParameter("getItemId") != null) {
            itemId = Integer.parseInt(request.getParameter("electronicsId"));
            RequestDispatcher rs = request.getRequestDispatcher("electronics-admin-change.jsp");
            rs.forward(request, response);
            return;
        }
        if (request.getParameter("deleteButton") != null) {
            try {
                int electronicsId = Integer.parseInt(request.getParameter("electronicsId"));
                electronicsDAO.deleteElectronics(electronicsId);
                RequestDispatcher rs = request.getRequestDispatcher("electronics-list.jsp");
                rs.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        } else if (request.getParameter("updateButton") != null) {
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            String summary = request.getParameter("category");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            float discount = Float.parseFloat(request.getParameter("discount"));
            String description = request.getParameter("description");
            String brand = request.getParameter("brand");
            try {
                electronicsDAO.addElectronics(name, price, summary, inventory, discount, description, brand);
            } catch (SQLException ex) {
                Logger.getLogger(ElectronicsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rs = request.getRequestDispatcher("electronics-admin.jsp");
            rs.forward(request, response);
            return;
        } else if (request.getParameter("changeButton") != null) {
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            String summary = request.getParameter("category");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            float discount = Float.parseFloat(request.getParameter("discount"));
            String description = request.getParameter("description");
            String brand = request.getParameter("brand");
            try {
                electronicsDAO.changeElectronics(itemId, name, price, summary, inventory, discount, description, brand);
            } catch (SQLException ex) {
                Logger.getLogger(ElectronicsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rs = request.getRequestDispatcher("electronics-admin.jsp");
            rs.forward(request, response);
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

