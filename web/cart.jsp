<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="model.Shipment"%>
<%@page import="model.Payment"%>
<%@page import="dao.CartDAO"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int totalAmout = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" href="bootstrap.min.css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="center_content">
            <div class="title cart_title">My cart</div>
            <table class="cart_table table table-striped">
                <tr style="height: 100px; font-size: 20px;">
                    <th style="width:20%">Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th></th>
                </tr>
                <%
                    ArrayList<Cart> list = null;
                    list = (ArrayList<Cart>) request.getAttribute("cartItem");
                    float sumPrice = 0;
                    String cartIdArr = "(";
                    if (list!=null) {
                    for (int i = 0; i < list.size(); i++) {
                        sumPrice += list.get(i).getTotalPrice();
                        cartIdArr=cartIdArr.concat(String.valueOf(list.get(i).getId()));
                        cartIdArr=cartIdArr.concat(", ");
                %>
                <tr class="cart_title" style="font-size: 15px">
                    <td style="width:20%"><%=list.get(i).getProductName()%></td>
                    <td><%=list.get(i).getAmount()%></td>
                    <td><%=list.get(i).getTotalPrice() / list.get(i).getAmount()%></td>
                    <td><%=list.get(i).getTotalPrice()%></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/Cart" method="post">
                            <input hidden type="text" name="cartItemId" value="<%=list.get(i).getId()%>" />
                            <input type="submit" class="btn btn-warning" name="deleteButton" value="Delete" />
                        </form>
                    </td>
                </tr>                            
                <%}
                    if (cartIdArr.length()>1) {
                        cartIdArr=cartIdArr.substring(0, cartIdArr.length()-2).concat(")");
                    }
                    }
                %>
            </table>

            <div class="cart_total">
                <div class="cart_total-text">Subtotal</div>
                <div class="cart_total-price"><%=sumPrice%> đ</div>
            </div>
            
            <form action="${pageContext.request.contextPath}/Cart" class="checkout" method="post" style="width: 800px;
    display: block;
    margin: 0 auto;">
                <div class="des_contents">
                    <div class="box_footer">
                        <p class="box_para">Select payment method:</p>
                        <select class="custom-select" name="paymentMethods" id="paymentMethods" style="width: 35%">
                            <%
                                CartDAO cartDAO = new CartDAO();
	                        ArrayList<Payment> paymentList = cartDAO.getPayemnts();
	                        for (int i = 0; i < paymentList.size(); i++) {
	                    %>
                                <option value="<%=paymentList.get(i).getId()%>"><%=paymentList.get(i).getMethod()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="box_footer">
                        <p class="box_para">Select shipment method: </p>
                        <select class="custom-select" name="shipmentMethods" id="shipmentMethods" style="width: 35%">
                            <%
	                        ArrayList<Shipment> shipmentList = cartDAO.getShipments();
	                        for (int i = 0; i < shipmentList.size(); i++) {
	                    %>
                                <option value="<%=shipmentList.get(i).getId()%>"><%=shipmentList.get(i).getType()%> - <%=shipmentList.get(i).getPrice()%>Đ</option>
                            <%}%>
                        </select>
                    </div>
                </div>

                <div class="cart_button">
                    <a class="btn btn-secondary" href="index.jsp" class="cart_btn">Continue Shopping</a>
                    <input hidden type="text" name="sumPrice" value="<%=sumPrice%>"/>
                    <input hidden type="text" name="cartIdArr" value="<%=cartIdArr%>"/>
                    <input type="submit" class="btn btn-primary" name="createOrder" class="cart_btn" value="Buy" />
                </div>
            </form>
        </div>
    </body>
</html>