
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
        <div id="wrap" >
            <%@include file="header.jsp" %>
            <div class="center_content ">
                <img src="https://image.shutterstock.com/image-vector/promo-sale-banner-bookstore-bookshop-260nw-1971130367.jpg" style="width:100%;" alt="alt"/>

                <h2 class="title">Books</h2>
                <div class="main_box row">
                    <%
                        ArrayList<Book> list = null;
                        BookDAO bookDao = new BookDAO();
                        list = bookDao.getBookNew();
                        for (int i = 0; i < list.size(); i++) {
                    %>
                    <div class="feat_prod_box col-md-3 mb-4" >
                        <div class="prod_det_box">
                            <div class="box_center card ">
                                <img class="card-img-top" src="https://salt.tikicdn.com/cache/400x400/ts/product/ac/80/5c/f91ecd9f50a35284e3fd68accf974d1d.jpg.webp" alt="alt"/>
                                <div class="box_title text-center "><%=list.get(i).getName()%></div>
                                <div class="box_footer">
                                    <p class="box_para">Price</p>
                                    <p class="box_price"><%=list.get(i).getPrice()%>đ</p>
                                </div>
                                <div class="box_footer">
                                    <p class="box_para">Discount</p>
                                    <p class="box_price"><%=list.get(i).getDiscount()%>%</p>
                                </div>
                                <div class="prod_img"><a href="Details?id=<%=list.get(i).getId()%>&name=Books">For more information</a></div>
                            </div>
                        </div>    
                    </div>      
                    <%}%>
                </div>


            </div>
        </div>
    </body>
</html>