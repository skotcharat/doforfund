<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />


<div class="site-section" data-aos="fade">
    <div class="container-fluid">
        <h1 class="text-center">Your Profile</h1><br>
     <p class="text-center"><span style="font-size:1vw;">Id: </span>${users.id}</p><br>
     <p class="text-center"><span style="font-size:1vw;">First Name: </span>${users.firstName}</p><br>
     <p class="text-center"><span style="font-size:1vw;">Last Name: </span>${users.lastName}</p><br>
     <p class="text-center"><span style="font-size:1vw;">User Name: </span>${users.userName}</p><br>
     <p class="text-center"><span style="font-size:1vw;">Password: </span>${users.password}</p><br>
     <p class="text-center"><span style="font-size:1vw;">Email: </span>${users.email}</p><br><br>

        <div class="row justify-content-center">
            <div class="col-md-1.5">
                <a href="editProfileWithId?EditWithId=${users.id}"><button class="btn btn-primary py-2 px-4  text-white">Edit Profile</button></a>
            </div>
        </div>
    </div>
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