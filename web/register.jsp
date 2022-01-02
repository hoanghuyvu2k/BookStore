<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body style="background: #fff">
        <div id="wrap">
            <div class="center_content" style="background: #fff">
                <div class="left_content login_form">
                    <div class="title login_title">Register</div>
                    <div class="feat_prod_box_details">
                        <div class="contact_form">
                            <form name="register" action="Register" method="post"> 
                                <div class="form_row" style="display: flex; justify-content: space-between;">
                                	<div class="form_row-child">
                                		<label class="contact"><strong>Last Name</strong></label>
                                    	<input type="text" class="contact_input" name="lastname" />
                                	</div>
                                	<div class="form_row-child">
                                		<label class="contact"><strong>Middle Name</strong></label>
                                    	<input type="text" class="contact_input" name="middlename" />
                                	</div>
                                	
                                	<div class="form_row-child">
                                		<label class="contact"><strong>First Name</strong></label>
                                    	<input type="text" class="contact_input" name="firstname" />
                                	</div>
                                </div>
                            	<div class="form_row">
                                    <label class="contact"><strong>Email</strong></label>
                                    <input type="text" class="contact_input" name="email"/>
                                </div>         
                                <div class="form_row">
                                    <label class="contact"><strong>Username</strong></label>
                                    <input type="text" class="contact_input" name="username"/>
                                </div>  
                                <div class="form_row">
                                    <label class="contact"><strong>Password</strong></label>
                                    <input type="password" class="contact_input" name="password" />
                                </div> 
                                
                                <!-- Address -->
                                <div class="form_row" style="display: flex; justify-content: space-between;">
                                	<div class="form_row-child">
                                		<label class="contact"><strong>Commune</strong></label>
                                    	<input type="text" class="contact_input" name="commune" />
                                	</div>
                                	<div class="form_row-child">
                                		<label class="contact"><strong>District</strong></label>
                                    	<input type="text" class="contact_input" name="district" />
                                	</div>
                                	
                                	<div class="form_row-child">
                                		<label class="contact"><strong>City</strong></label>
                                    	<input type="text" class="contact_input" name="city" />
                                	</div>
                                </div>

                                <div class="form_footer">
                                    <p>Already have an account?  <a href="login.jsp">Login</a> here</p>
                                    <button type="submit" class="register">Sign Up</button>
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