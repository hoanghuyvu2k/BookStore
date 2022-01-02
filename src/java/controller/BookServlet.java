package controller;

import dao.BookDAO;
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
import model.Order;
import model.Book;
import model.Customer;
import model.Account;

@WebServlet("/Books")
public class BookServlet extends HttpServlet {
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
        String addButton = request.getParameter("addButton");
        HttpSession session = request.getSession();
        if (session.getAttribute("customerID") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        BookDAO bookDAO = new BookDAO();
        int itemId = -1;
        if (request.getParameter("getItemId") != null) {
            itemId = Integer.parseInt(request.getParameter("bookId"));
            RequestDispatcher rs = request.getRequestDispatcher("book-admin-change.jsp");
            rs.forward(request, response);
            return;
        }
        int itemAuthorId = -1;
        if (request.getParameter("getItemAuthorId") != null) {
            itemId = Integer.parseInt(request.getParameter("authorId"));
            RequestDispatcher rs = request.getRequestDispatcher("author-admin-change.jsp");
            rs.forward(request, response);
            return;
        }
        int itemPublisherId = -1;
        if (request.getParameter("getItemPublisherId") != null) {
            itemId = Integer.parseInt(request.getParameter("publisherId"));
            RequestDispatcher rs = request.getRequestDispatcher("publisher-admin-change.jsp");
            rs.forward(request, response);
            return;
        }
        if (request.getParameter("deleteButton") != null) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            try {
                bookDAO.deleteBook(bookId);
                RequestDispatcher rs = request.getRequestDispatcher("books-list.jsp");
                rs.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        } else if (request.getParameter("changeButton") != null) {
            String title = request.getParameter("title");
            float price = Float.parseFloat(request.getParameter("price"));
            String summary = request.getParameter("summary");
            String language = request.getParameter("language");
            String category = request.getParameter("category");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            float discount = Float.parseFloat(request.getParameter("discount"));
            String description = request.getParameter("description");
            int authorId = Integer.parseInt(request.getParameter("authorId"));
            int publisherId = Integer.parseInt(request.getParameter("publisherId"));
            
            try {
                bookDAO.changeBook(itemId, title, price, summary, language, category, inventory, discount, description, authorId, publisherId);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
            return;
        } else if (request.getParameter("updateButton") != null) {
            String title = request.getParameter("title");
            float price = Float.parseFloat(request.getParameter("price"));
            String summary = request.getParameter("summary");
            String language = request.getParameter("language");
            String category = request.getParameter("category");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            float discount = Float.parseFloat(request.getParameter("discount"));
            String description = request.getParameter("description");
            int authorId = Integer.parseInt(request.getParameter("authorId"));
            int publisherId = Integer.parseInt(request.getParameter("publisherId"));
            try {
                bookDAO.addBook(title, price, summary, language, category, inventory, discount, description, authorId, publisherId);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
            return;
        } else if (request.getParameter("updateButtonAuthor") != null) {
            String authorName = request.getParameter("authorName");
            String biography = request.getParameter("biography");
            
            try {
                bookDAO.addAuthor(authorName, biography);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
            return;
        } else if (request.getParameter("updateButtonPublisher") != null) {
            String publisherName = request.getParameter("publisherName");
            String address = request.getParameter("address");
            
            try {
                bookDAO.addPublisher(publisherName, address);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
            return;
        } else if (request.getParameter("changeButtonPublisher") != null) {
            String publisherName = request.getParameter("publisherName");
            String address = request.getParameter("address");
            try {
                bookDAO.chagePublisher(itemPublisherId, address, address);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
        } else if (request.getParameter("changeButtonAuthor") != null) {
            String authorName = request.getParameter("authorName");
            String biography = request.getParameter("biography");
            
            try {
                bookDAO.chageAuthor(itemAuthorId, authorName, biography);
            } catch (SQLException ex) {
                Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rs = request.getRequestDispatcher("book-admin.jsp");
            rs.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
