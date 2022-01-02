package controller;

import dao.BookDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Book;

/**
 *
 * @author Administrator
 */
@WebServlet("/Details")
public class Details extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Details</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Details at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        BookDAO bookDAO = new BookDAO();
       
        HttpSession session = request.getSession(true);
        System.out.println(session.getAttribute("customerID"));
        if (new String(name).equals("Books")) {
            Book book = bookDAO.getBookById(Integer.parseInt(id));
            request.setAttribute("book", book);
            RequestDispatcher rs = request.getRequestDispatcher("book-details.jsp");
            rs.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
