<%@page import="model.Book"%>
<%@page import="model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="right_content">
    <div class="cart">
        <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" title="" /></span>Giỏ hàng</div>
        <div class="home_cart_content" style="color:  red;">
            <% Order order = (Order) session.getAttribute("ORDER");
                if (order != null) {
            %> 
            <%= order.getListBook().size()%>x cuốn| <span class="red">Tổng: 
                <%
                    int price = 0;
                    for (Book book : order.getListBook()) {
                        price += book.getPrice();
                    }
                    out.print(price);
                %>
            </span>
            <%}%>
        </div>
        <a href="cart.jsp" class="view_cart">Xem giỏ hàng</a>

    </div>




    <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>Thông tin về chúng tôi</div> 
    <div class="about">
        <p>
            <img src="images/about.gif" alt="" title="" class="right" />
            Hiệu sách book store ngụ tại số 30 Trần Phú Học viện Công nghệ Bưu chính Viễn thông. Qua 5 tháng hình thành và phát triển chúng tôi đã tích lũy được vô số kinh nghiệm làm việc.
        </p>

    </div>
</div><!--end of right content-->