<%@page import="dao.CartDAO"%>
<%@page import="model.Cart"%>

<%@page import="dao.BookDAO"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Ecommerce</title>
        <link rel="stylesheet" type="text/css" href="style.css" />

    </head>
    <body>
        <div id="wrap">
            <%@include file="header-admin.jsp" %>
            <div class="center_content">
                <h2 class="title">Orders</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">CustomerId</th>
                            <th scope="col">Item</th>
                            <th scope="col">Type</th>
                            <th scope="col">Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Cart> listItem = null;
                            CartDAO cartDao = new CartDAO();
                            listItem = cartDao.showCartItems(0, 1);
                            for (int i = 0; i < listItem.size(); i++) {
                        %>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=listItem.get(i).getCustomerId()%></td>
                            <td><%=listItem.get(i).getProductName()%></td>
                            <td><%=listItem.get(i).getItemType()%></td>
                            <td><%=listItem.get(i).getAmount()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>  
            </div>
        </div>
    </body>
</html>