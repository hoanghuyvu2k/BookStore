<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="bootstrap.min.css">
<div class="header">
    <div id="logo">
        <a href="index.jsp">Ecommerce admin</a>
    </div>
    <div id="menu">
        <ul>
            <li><a href="books-list.jsp">Books</a></li>
            <li><a href="author-list.jsp">Author</a></li>
            <li><a href="publisher-list.jsp">Publisher</a></li>
            <li><a href="electronics-list.jsp">Electronics</a></li>
            <li><a href="clothes-list.jsp">Clothes</a></li>
            <li><a href="shoes-list.jsp">Shoes</a></li>
            <li><a href="order-list.jsp">Orders</a></li>
                <%Account account = (Account) session.getAttribute("USER");
                    if (account != null) {
                        String username = account.getUsername();
                %>
            <li><a href="login.jsp">Logout</a></li>
            <li><a href="login.jsp">Hello <%=username%></a></li>
                <%} else {%>
            <li><a href="login.jsp">Sign in</a></li>
            <li><a href="register.jsp">Register</a></li>
                <%}%>
        </ul>
    </div>   
</div> 