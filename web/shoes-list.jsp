<%@page import="dao.ShoesDAO"%>
<%@page import="model.Shoes"%>
<%@page import="dao.ClothesDAO"%>
<%@page import="model.Clothes"%>
<%@page import="dao.ElectronicsDAO"%>
<%@page import="model.Electronics"%>
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
                <h2 class="title">Add Shoes</h2>
                <a class="btn btn-success" href="shoes-admin.jsp">Add</a>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Title</th>
                            <th scope="col">Price</th>
                            <th scope="col">Discount</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Shoes> listShoes = null;
                            ShoesDAO shoesDao = new ShoesDAO();
                            listShoes = shoesDao.getShoesNew();
                            for (int i = 0; i < listShoes.size(); i++) {
                        %>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=listShoes.get(i).getName()%></td>
                            <td><%=listShoes.get(i).getPrice()%>đ</td>
                            <td><%=listShoes.get(i).getDiscount()%>%</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/Shoes" method="post">
                                    <input hidden type="text" name="shoesId" value="<%=listShoes.get(i).getId()%>" />
                                    <input type="submit" class="btn btn-danger" name="deleteButton" value="Delete" />
                                    <input type="submit" class="btn btn-danger" name="getItemId" value="Change" />
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>  
            </div>
        </div>
    </body>
</html>