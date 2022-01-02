package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.Customer;
import model.Fullname;

@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private CustomerDAO csd = new CustomerDAO();;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String lastname = request.getParameter("lastname");
            String middlename = request.getParameter("middlename");
            String fisrtname = request.getParameter("firstname");
            String email = request.getParameter("email");
            String commune = request.getParameter("commune");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            
            Customer customer = new Customer();
            customer.setEmail(email);
            
            Fullname fullname = new Fullname();
            fullname.setFirstName(fisrtname);
            fullname.setLastName(lastname);
            fullname.setMiddleName(middlename);

            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);

            Address address = new Address();
            address.setCity(city);
            address.setCommune(commune);
            address.setDistrict(district);
            
            if(csd.checkExistedAccount(account)){
                response.sendRedirect("register.jsp?checklogin=false");
            }
            else{
                csd.addCustomer(customer);
                csd.addAccount(account, customer);
                csd.addAddress(address, customer);
                csd.addFullname(fullname, customer);
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
