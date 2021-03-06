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
                        <h2 class="site-section-heading text-center">Edit Event</h2>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-8 mb-5">
                        <form action="editEventAction" method="POST">
                            <input type="hidden" name="ParameterId" class="form-control" value="${eventEdit.id}" />

                            <div class="row form-group">
                                <div class="col-md-6 mb-3 mb-md-0">
                                    <label class="text-black" for="eventName">Event name</label>
                                    <input type="text" id="eventName" name="eventName" class="form-control" value="${eventEdit.eventName}">
                                </div>
                                <div class="col-md-6">
                                    <label class="text-black" for="eventPlace">Event Place</label>
                                    <input type="text" id="eventPlace" name="eventPlace" class="form-control" value="${eventEdit.eventPlace}">
                                </div>
                            </div>

                            <div class="row form-group">

                                <div class="col-md-12">
                                    <label class="text-black" for="eventDate">Event Date</label>
                                    <input type="date" id="eventDate" name="eventDate" class="form-control" value="${eventEdit.eventDate}">
                                </div>
                            </div>

                            <div class="row form-group">

                                <div class="col-md-12">
                                    <label class="text-black" for="eventTime">Event Time</label>
                                    <input type="time" id="eventTime" name="eventTime" class="form-control" value="${eventEdit.eventTime}">
                                </div>
                            </div>

                            <div class="row form-group">

                                <div class="col-md-12">
                                    <label class="text-black" for="eventDescription">Event Description</label>
                                    <input type="text" id="eventDescription" name="eventDescription" class="form-control" value="${eventEdit.eventDescription}">
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-12">
                                    <input type="submit" name="submit" value="Edit Event" class="btn btn-primary py-2 px-4 text-white">
                                </div>
                            </div>


                        </form>
                    </div>


                    </div>
                </div>
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