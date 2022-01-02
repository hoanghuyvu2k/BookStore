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
                    <div class="title login_title">Change Shoes</div>
                    <div class="feat_prod_box_details">
                        <div class="contact_form">
                            <form name="shoes-admin" action="Shoes" method="post">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" name="name" placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="text" class="form-control" name="price" placeholder="Price">
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <input type="text" class="form-control" name="category" placeholder="Category">
                                </div>
                                <div class="form-group">
                                    <label>Color</label>
                                    <input type="text" class="form-control" name="color" placeholder="Color">
                                </div>
                                <div class="form-group">
                                    <label>Material</label>
                                    <input type="text" class="form-control" name="material" placeholder="Material">
                                </div>
                                <div class="form-group">
                                    <label>Brand</label>
                                    <input type="text" class="form-control" name="brand" placeholder="Brand">
                                </div>
                                <div class="form-group">
                                    <label>Size</label>
                                    <input type="text" class="form-control" name="size" placeholder="Size">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <input type="text" class="form-control" name="description" placeholder="Description">
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
                                    <label>Type</label>
                                    <input type="text" class="form-control" name="type" placeholder="Type">
                                </div>
                                <input type="submit" class="btn btn-warning" name="changeButton" value="Update" />
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