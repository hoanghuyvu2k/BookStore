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
            <%@include file="header.jsp" %>
            <div class="center_content">
                    <h2 class="title">Books</h2>
                    <div class="main_box">
                            <%
	                        ArrayList<Book> list = null;
	                    	BookDAO bookDao = new BookDAO();
	                        list = bookDao.getBookNew();
	                        for (int i = 0; i < list.size(); i++) {
	                    %>
                            <div class="feat_prod_box" style="width: 300px">
	                        <div class="prod_det_box">
	                            <div class="box_center">
	                                <div class="box_title"><%=list.get(i).getName()%></div>
	                                <div class="box_footer">
	                                	<p class="box_para">Price</p>
	                                	<p class="box_price"><%=list.get(i).getPrice() %>đ</p>
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
                    
                    <h2 class="title">Electronics</h2>
                    <div class="main_box">
                            <%
	                        ArrayList<Electronics> listElectronics = null;
	                    	ElectronicsDAO electronicsDAO = new ElectronicsDAO();
	                        listElectronics = electronicsDAO.getElectronicsNew();
	                        for (int i = 0; i < listElectronics.size(); i++) {
	                    %>
                            <div class="feat_prod_box" style="width: 300px">
	                        <div class="prod_det_box">
	                            <div class="box_center">
	                                <div class="box_title"><%=listElectronics.get(i).getName()%></div>
	                                <div class="box_footer">
	                                	<p class="box_para">Price</p>
	                                	<p class="box_price"><%=listElectronics.get(i).getPrice() %>đ</p>
	                                </div>
                                        <div class="box_footer">
                                            <p class="box_para">Discount</p>
                                            <p class="box_price"><%=listElectronics.get(i).getDiscount()%>%</p>
                                        </div>
                                        <div class="prod_img"><a href="Details?id=<%=listElectronics.get(i).getId()%>&name=Electronics">For more information</a></div>
	                            </div>
	                        </div>    
	                    </div>      
	                    <%}%>
                    </div>
                    
                    <h2 class="title">Clothes</h2>
                    <div class="main_box">
                            <%
	                        ArrayList<Clothes> listClothes = null;
	                    	ClothesDAO clothesDao = new ClothesDAO();
	                        listClothes = clothesDao.getClothesNew();
	                        for (int i = 0; i < listClothes.size(); i++) {
	                    %>
	
                            <div class="feat_prod_box" style="width: 300px">
	                        <div class="prod_det_box">
	                            <div class="box_center">
	                                <div class="box_title"><%=listClothes.get(i).getName()%></div>
	                                <div class="box_footer">
	                                	<p class="box_para">Price</p>
	                                	<p class="box_price"><%=listClothes.get(i).getPrice() %>đ</p>
	                                </div>
                                        <div class="box_footer">
                                            <p class="box_para">Discount</p>
                                            <p class="box_price"><%=listClothes.get(i).getDiscount()%>%</p>
                                        </div>
                                        <div class="prod_img"><a href="Details?id=<%=listClothes.get(i).getId()%>&name=Clothes">For more information</a></div>
	                            </div>
	                        </div>    
	                    </div>      
	                    <%}%>
                    </div>
                    
                    <h2 class="title">Shoes</h2>
                    <div class="main_box" style="margin-bottom: 20px">
                            <%
	                        ArrayList<Shoes> listShoes = null;
	                    	ShoesDAO shoesDao = new ShoesDAO();
	                        listShoes = shoesDao.getShoesNew();
	                        for (int i = 0; i < listShoes.size(); i++) {
	                    %>
                            <div class="feat_prod_box" style="width: 300px">
	                        <div class="prod_det_box">
	                            <div class="box_center">
	                                <div class="box_title"><%=listShoes.get(i).getName()%></div>
	                                <div class="box_footer">
	                                	<p class="box_para">Price</p>
	                                	<p class="box_price"><%=listShoes.get(i).getPrice() %>đ</p>
	                                </div>
                                        <div class="box_footer">
                                            <p class="box_para">Discount</p>
                                            <p class="box_price"><%=listShoes.get(i).getDiscount()%>%</p>
                                        </div>
                                        <div class="prod_img"><a href="Details?id=<%=listShoes.get(i).getId()%>&name=Shoes">For more information</a></div>
	                            </div>
	                        </div>    
	                    </div>      
	                    <%}%>
                    </div>
            </div>
        </div>
    </body>
</html>