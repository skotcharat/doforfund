<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />
<html>
<head>
    <title>Login</title>


    <div class="site-section" data-aos="fade">
        <div class="container-fluid">

            <div class="row justify-content-center">
                <div class="col-md-7">
                    <div class="row mb-5">
                        <div class="col-12 ">
                            <h2 class="site-section-heading text-center">Sign in</h2>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-8 mb-5">
                            <FORM ACTION="j_security_check" METHOD="POST">


                                <div class="row form-group">
                                    <div class="col-md-6 mb-3 mb-md-0">
                                        <label class="text-black" for="j_username">User name</label>
                                        <input type="text" id="j_username" name="j_username" class="form-control">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="text-black" for="j_password">Password</label>
                                        <input type="PASSWORD" id="j_password" name="j_password" class="form-control">
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-md-12">
                                        <input type="submit" name="submit" value="Sign in" class="btn btn-primary py-2 px-4 text-white">
                                    </div>
                                </div>


                            </form>
                        </div>


                    </div>
                </div>
            </div>

        </div>
    </div>


</head>
<body>

</body>

<div class="footer py-4">
    <jsp:include page="footer.jsp" />
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
</html>
