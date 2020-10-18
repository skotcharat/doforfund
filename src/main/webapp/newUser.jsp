<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />

<div>
    <p class="text-black h2 mb-0 text-center">Your account has been successfully create</p><br><br>
    <p class="text-center">Please Login</p><br>
    <form action="loginUser" method="GET">

        <div class="row form-group">

            <div class="col-md-12">
                <label class="text-black" for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control">
            </div>
        </div>

        <div class="row form-group">

            <div class="col-md-12">
                <label class="text-black" for="password">Password</label>
                <input type="text" id="password" name="password" class="form-control">
            </div>
        </div>

        <div class="row form-group">
            <div class="col-md-12">
                <input type="submit" name="submit" value="Send Message" class="btn btn-primary py-2 px-4 text-white">
            </div>
        </div>


    </form>

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