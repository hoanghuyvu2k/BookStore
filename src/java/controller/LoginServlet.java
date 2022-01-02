package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.CustomerDAO;
import javax.servlet.annotation.WebServlet;
import model.Account;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pasword = request.getParameter("password");
        Account account = new Account(username, pasword);
        CustomerDAO customerDAO = new CustomerDAO();
        
        if (customerDAO.checkLogin(account)>0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("customerID", customerDAO.checkLogin(account));
            session.setAttribute("USER", account);
            if (new String(username).equals("admin")) {
                response.sendRedirect("book-admin.jsp");
                return;
            } 
            response.sendRedirect("index.jsp");
            return;
        } else {
            response.sendRedirect("login.jsp?checklogin=false");
        }
	}
	
	@Override
    public String getServletInfo() {
        return "Short description";
    }

}
