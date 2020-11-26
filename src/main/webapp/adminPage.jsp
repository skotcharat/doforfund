<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />



<div class="site-section"  data-aos="fade">
    <div class="container-fluid">

        <div class="row justify-content-center">
            <div class="col-md-7">
                <h3>Users</h3>
                <table border=1 width=30% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>UserName</th>
                        <th>Password</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach items="${users}" var="allUser">
                        <tr>
                            <td>${allUser.id}</td>
                            <td>${allUser.firstName}</td>
                            <td>${allUser.lastName}</td>
                            <td>${allUser.userName}</td>
                            <td>${allUser.password}</td>
                            <td>${allUser.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-7">
                <h3>Events</h3>
                <table border=1 width=30% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>Event Name</th>
                        <th>Event Place</th>
                        <th>Event Date</th>
                        <th>Event Time</th>
                        <th>event Description</th>
                    </tr>
                    <c:forEach items="${events}" var="allEvent">
                        <tr>
                            <td>${allEvent.id}</td>
                            <td>${allEvent.eventName}</td>
                            <td>${allEvent.eventPlace}</td>
                            <td>${allEvent.eventDate}</td>
                            <td>${allEvent.eventTime}</td>
                            <td>${allEvent.eventDescription}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-7">
                <h3>Donations</h3>
                <table border=1 width=30% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>Date</th>

                    </tr>
                    <c:forEach items="${events}" var="allEvent">
                        <tr>
                            <td>${allEvent.id}</td>
                            <td>${allEvent.amount}</td>
                            <td>${allEvent.date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-7">
                <h3>Donations</h3>
                <table border=1 width=30% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>Date</th>

                    </tr>
                    <c:forEach items="${events}" var="allEvent">
                        <tr>
                            <td>${allEvent.id}</td>
                            <td>${allEvent.amount}</td>
                            <td>${allEvent.date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="footer py-4">
    <div class="container-fluid text-center">
        <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        </p>
    </div>
</div>



</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/jquery.countdown.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/aos.js"></script>

<script src="js/picturefill.min.js"></script>
<script src="js/lightgallery-all.min.js"></script>
<script src="js/jquery.mousewheel.min.js"></script>

<script src="js/main.js"></script>

<script>
    $(document).ready(function(){
        $('#lightgallery').lightGallery();
    });
</script>

</body>
</html>