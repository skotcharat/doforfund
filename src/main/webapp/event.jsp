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
          <div class="row mb-5">
            <div class="col-12 ">
              <h2 class="site-section-heading text-center">Our Events</h2>
            </div>
          </div>

          <div class="row">
            <c:forEach items="${allEvent}" var="allEvents">

            <div class="col-md-6 col-lg-6 col-xl-4 text-center mb-5 mb-lg-5">
              <div class="h-100 p-4 p-lg-5 bg-light site-block-feature-7">
                <span class="icon flaticon-camera display-3 text-primary mb-4 d-block"></span>
                <h3 class="text-black h4">${allEvents.eventName}</h3>
                <p>${allEvents.eventDescription}</p>
                <p>At <strong class="font-weight-bold text-primary">${allEvents.eventPlace}</strong></p>
                <p><strong class="font-weight-bold text-primary">${allEvents.eventDate}</strong></p>
                <p><strong class="font-weight-bold text-primary">${allEvents.eventTime}</strong></p>
                <a href="logout.jsp"><button class="btn btn-primary py-2 px-5 text-white">Sign up an event</button></a>
              </div>
            </div>

            </c:forEach>
          </div>
        </div>

      </div>
    </div>
  </div>


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

    
  </body>

</html>