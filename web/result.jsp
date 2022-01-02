<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />

    </head>
    <body>
        <div id="wrap">

            <%@include file="header.jsp" %>
            <div class="center_content">
                <div class="left_content">
                    <div class="title">Category books</div>

                    <div class="main_box">

                        <%
                            ArrayList<Book> arr = (ArrayList<Book>) session.getAttribute("RESULT");
                            if (arr != null && arr.size() > 0) {
                        %>
                        <% for (Book book : arr) {%>
                       
                        <div class="feat_prod_box">
	                        <div class="prod_det_box">
	                            <div class="box_center">
	                                <div class="box_title"><%=book.getName()%></div>
	                                <div class="box_author">N.V.Trung</div>
	                                <div class="box_footer">
	                                	<p class="box_para">Price</p>
	                                	<p class="box_price"><%=book.getPrice() %>đ</p>
	                                </div>
	                            </div>
	
	                            
	                        </div>    
	                    </div>
                        <%}
                            }%>
                          

                    </div> 


                    
                </div><!--end of left content-->


                <div class="clear"></div>
            </div><!--end of center content-->
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>