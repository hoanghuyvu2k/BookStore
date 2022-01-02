<%@page import="model.Author"%>
<%@page import="dao.BookDAO"%>
<%@page import="model.Publisher"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" href="bootstrap.min.css">
    </head>
    <body style="background: #fff">
        <div id="wrap">
            <%@include file="header-admin.jsp" %>
            <div class="center_content" style="background: #fff">
                <div class="left_content login_form">
                    <div class="title login_title">Add Books</div>
                    <div class="feat_prod_box_details">
                        <div class="contact_form">
                            <form name="book-admin" action="${pageContext.request.contextPath}/Books" method="post">
                                <div class="form-group">
                                    <label>Title</label>
                                    <input type="text" class="form-control" name="title" placeholder="Title">
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="text" class="form-control" name="price" placeholder="Price">
                                </div>
                                <div class="form-group">
                                    <label>Summary</label>
                                    <input type="text" class="form-control" name="summary" placeholder="Summary">
                                </div>
                                <div class="form-group">
                                    <label>Language</label>
                                    <input type="text" class="form-control" name="language" placeholder="Language">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <input type="text" class="form-control" name="category" placeholder="Category">
                                </div>
                                <div class="form-group">
                                    <label>Inventory</label>
                                    <input type="text" class="form-control" name="inventory" placeholder="Inventory">
                                </div>
                                <div class="form-group">
                                    <label>Discount</label>
                                    <input type="text" class="form-control" name="discount" placeholder="Discount">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <input type="text" class="form-control" name="description" placeholder="Description">
                                </div>
                                <div class="form-group">
                                    <label>Author</label>
                                    <select name="authorId" class="custom-select">
                                        <%
                                            ArrayList<Author> listA = null;
                                            BookDAO bookDao = new BookDAO();
                                            listA = bookDao.getAuthorList();
                                            for (int i = 0; i < listA.size(); i++) {
                                        %>
                                        <option value="<%=listA.get(i).getId()%>"><%=listA.get(i).getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Publisher</label>
                                    <select name="publisherId" class="custom-select">
                                        <%
                                            ArrayList<Publisher> listP = null;
                                            listP = bookDao.getPublisherList();
                                            for (int i = 0; i < listP.size(); i++) {
                                        %>
                                        <option value="<%=listP.get(i).getId()%>"><%=listP.get(i).getName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <input type="submit" class="btn btn-warning" name="updateButton" value="Add" />
                            </form>
                        </div>  
                    </div>	
                    <div class="clear"></div>
                </div><!--end of left content-->
                <div class="clear"></div>
            </div><!--end of center content-->
        </div>
    </body>
</html>