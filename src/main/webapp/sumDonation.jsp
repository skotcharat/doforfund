<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />

<div>
    <p class="text-black h2 mb-0 text-center">Thank you. We were received your Fund</p><br><br>
    <H2 class="text-center">Your Fund is</H2><br>
    <H3 class="text-center">$${donateAmount.amount}.00</H3><br><br>
    <H2 class="text-center">Your fund helps increase the total fund to</H2><br>

    <c:set var="total" value="${0}"/>
    <c:forEach var="totalAmounts" items="${totalAmount}">
        <c:set var="total" value="${total + totalAmounts.amount}" />
    </c:forEach>
    <H3 class="text-center">$${total}.00</H3><br>

    <p class="text-black h4 mb-0 text-center"></p><br><br><br><br><br><br><br>

</div>
<div class="footer py-4">
    <jsp:include page="footer.jsp" />
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