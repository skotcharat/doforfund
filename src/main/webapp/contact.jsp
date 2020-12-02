<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />


  <div class="site-section" data-aos="fade">
    <div class="container-fluid">
      
      <div class="row justify-content-center">
        <div class="col-md-7">
          <div class="row mb-5">
            <div class="col-12 ">
              <h2 class="site-section-heading text-center">Contact Us</h2>
            </div>
          </div>

          <div class="row">
            <div class="col-lg-8 mb-5">
              <form action="contactInfo" method="GET">
               

                <div class="row form-group">
                  <div class="col-md-6 mb-3 mb-md-0">
                    <label class="text-black" for="fname">First Name</label>
                    <input type="text" id="fname" name="fname" class="form-control">
                  </div>
                  <div class="col-md-6">
                    <label class="text-black" for="lname">Last Name</label>
                    <input type="text" id="lname" name="lname" class="form-control">
                  </div>
                </div>

                <div class="row form-group">
                  
                  <div class="col-md-12">
                    <label class="text-black" for="email">Email</label> 
                    <input type="email" id="email" name="email" class="form-control">
                  </div>
                </div>

                <div class="row form-group">
                  
                  <div class="col-md-12">
                    <label class="text-black" for="subject">Subject</label> 
                    <input type="subject" id="subject" name="subject" class="form-control">
                  </div>
                </div>

                <div class="row form-group">
                  <div class="col-md-12">
                    <label class="text-black" for="message">Message</label> 
                    <textarea name="message" name="message" id="message" cols="30" rows="7" class="form-control" placeholder="Write your message or questions here..."></textarea>
                  </div>
                </div>

                <div class="row form-group">
                  <div class="col-md-12">
                    <input type="submit" name="submit" value="Send Email" class="btn btn-primary py-2 px-4 text-white">
                  </div>
                </div>

    
              </form>
            </div>
            <div class="col-lg-3 ml-auto">
              <div class="mb-3 bg-white">

                <p class="mb-0 font-weight-bold">Phone</p>
                <p class="mb-4"><a href="#">+1 232 3235 324</a></p>

                <p class="mb-0 font-weight-bold">Email Address</p>
                <p class="mb-0"><a href="#">Doforfund@domain.com</a></p>

              </div>
              
            </div>
          </div>
        </div>
    
      </div>
    </div>
  </div>

<div class="footer py-4">
  <div class="footer py-4">
    <jsp:include page="footer.jsp" />
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