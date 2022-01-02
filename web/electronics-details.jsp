<%@page import="model.Electronics"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" href="lightbox.css" type="text/css" media="screen" />

        <script src="js/prototype.js" type="text/javascript"></script>
        <script src="js/scriptaculous.js?load=effects" type="text/javascript"></script>
        <script src="js/lightbox.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/java.js"></script>
        <%
            String message = (String) session.getAttribute("message");
            if (message != null) {
        %>
        <script>
            alert("<%=message%>");
        </script>
        <%
        session.removeAttribute("message");
            }%>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <% Electronics electronics = (Electronics) request.getAttribute("electronics");%>
        <div class="center_content">
            <div class="product">
                <div class="product_des">
                    <h3><%=electronics.getName()%></h3>
                    <p><%=electronics.getBrand()%></p>
                    <div class="product_price"><%=electronics.getPrice()%>đ</div>
                    <a href="Order?id=<%=electronics.getId()%>&name=Electronics&price=<%=electronics.getPrice()%>&productName=<%=electronics.getName()%>" class="product_add">
                        Add To Cart
                    </a>
                </div>
            </div>
            <div class="des">
                <div class="des_contents">
                    <div class="box_footer">
                        <p class="box_para">Category:</p>
                        <p class="box_price"><%=electronics.getCategory()%></p>
                    </div>
                    <div class="box_footer">
                        <p class="box_para">Description:</p>
                        <p class="box_price"><%=electronics.getDescription()%></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
