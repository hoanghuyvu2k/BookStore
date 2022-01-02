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
                    <div class="title login_title">Change Author</div>
                    <div class="feat_prod_box_details">
                        <div class="contact_form">
                            <form name="author-admin" action="Books" method="post">
                                    <label>Author name</label>
                                    <input type="text" class="form-control" name="authorName" placeholder="Author name">
                                </div>
                                <div class="form-group">
                                    <label>Biography</label>
                                    <input type="text" class="form-control" name="biography" placeholder="Biography">
                                </div>
                                <input type="submit" class="btn btn-warning" name="changeButtonAuthor" value="Update" />
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