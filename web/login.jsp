<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body style="background: #fff">
        <div id="wrap" >

            <div class="center_content" style="background: #fff">
                <div class="left_content login_form">
                    <div class="title login_title">Login</div>
                    <div class="feat_prod_box_details">
                        <% if (request.getParameter("checklogin") != null && request.getParameter("checklogin").equals("false")) {%>
                        <p class="details" style="color: red">
                            Login Fail
                        </p>
                        <%}%>
                        <div class="contact_form">
                            <form name="login" action="LoginServlet" method="post">          
                                <div class="form_row">
                                    <label class="contact"><strong>Username</strong></label>
                                    <input type="text" name="username" class="contact_input" placeholder="Username"/>
                                </div>  


                                <div class="form_row">
                                    <label class="contact"><strong>Password</strong></label>
                                    <input type="password" name="password"class="contact_input" placeholder="Password"/>
                                </div> 

                                <div class="form_footer">
                                	<p>Don’t have an account? <a href="register.jsp">Sign up</a> here</p>
                                	<button type="submit" class="register" value="login">Login</button>
                                </div>   
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