<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>
<br><br>

<jsp:include page="header.jsp" />
<div class="text-black h2 mb-0 text-center">
    <c:choose>
        <c:when test="${(pageContext.request.isUserInRole('admin'))}">
            <p>Welcome, ${pageContext.request.remoteUser}</p>
            <a href = "adminPage">Admin Page</a>
        </c:when>
        <c:when test="${(pageContext.request.isUserInRole('user'))}">
            <p>Welcome, ${pageContext.request.remoteUser}</p>
            <a href = "displayProfiles" >Profile</a>
        </c:when>
    </c:choose>
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