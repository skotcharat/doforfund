<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>

<jsp:include page="header.jsp" />

<div class="site-section"  data-aos="fade">
    <div class="container-fluid">

        <div class="row justify-content-center">
            <div class="col-md-10">
                <h3>Users</h3>
                <table border=1 width=60% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>UserName</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>

                    </tr>
                    <c:forEach items="${users}" var="allUser">
                        <tr>
                            <td>${allUser.id}</td>
                            <td>${allUser.firstName}</td>
                            <td>${allUser.lastName}</td>
                            <td>${allUser.userName}</td>
                            <td>${allUser.password}</td>
                            <td>${allUser.email}</td>

                            <td>
                            <c:forEach items="${allUser.userRoles}" var="roleUser">
                                ${roleUser.roleName}
                            </c:forEach>
                            </td>


                            <td><a href="editUserWithId?EditWithId=${allUser.id}"><button type="button">Edit</button></a></td>
                            <td><a href="deleteUserWithId?DeleteWithId=${allUser.id}"><button type="button">Delete</button></a></td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <br><br>
        <div class="row justify-content-center">
            <div class="col-md-10">
                <h3>Events</h3>

                <a href="addEvent.jsp"><button class="btn btn-primary py-2 px-4 text-white">Add Event</button></a>

                <table border=1 width=60% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>Event Name</th>
                        <th>Event Place</th>
                        <th>Event Date</th>
                        <th>Event Time</th>
                        <th>event Description</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${events}" var="allEvent">
                        <tr>
                            <td>${allEvent.id}</td>
                            <td>${allEvent.eventName}</td>
                            <td>${allEvent.eventPlace}</td>
                            <td>${allEvent.eventDate}</td>
                            <td>${allEvent.eventTime}</td>
                            <td>${allEvent.eventDescription}</td>
                            <td><a href="editEventWithId?EditWithId=${allEvent.id}"><button type="button">Edit</button></a></td>
                            <td><a href="deleteEventWithId?DeleteWithId=${allEvent.id}"><button type="button">Delete</button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <br><br>
        <div class="row justify-content-center">
            <div class="col-md-10">
                <h3>Donations</h3>
                <c:set var="total" value="${0}"/>
                <c:forEach var="totalAmounts" items="${donations}">
                    <c:set var="total" value="${total + totalAmounts.amount}" />
                </c:forEach>
                <H4 >Total funds are $${total}.00</H4><br>
                <table border=1 width=60% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${donations}" var="allDonation">
                        <tr>
                            <td>${allDonation.id}</td>
                            <td>${allDonation.amount}</td>
                            <td>${allDonation.date}</td>
                            <td><a href="editDonationWithId?EditWithId=${allDonation.id}"><button type="button">Edit</button></a></td>
                            <td><a href="deleteDonationWithId?DeleteWithId=${allDonation.id}"><button type="button">Delete</button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <br><br>
        <div class="row justify-content-center">
            <div class="col-md-10">
                <h3>Contact</h3>
                <table border=1 width=60% height=40% text-align="center">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Subject</th>
                        <th>message</th>
                        <th>UserName</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${contacts}" var="allContact">
                        <tr>
                            <td>${allContact.id}</td>
                            <td>${allContact.firstname}</td>
                            <td>${allContact.lastname}</td>
                            <td>${allContact.email}</td>
                            <td>${allContact.subject}</td>
                            <td>${allContact.message}</td>
                            <td>${allContact.userName}</td>

                            <td><a href="editContactWithId?EditWithId=${allContact.id}"><button type="button">Edit</button></a></td>
                            <td><a href="deleteContactWithId?DeleteWithId=${allContact.id}"><button type="button">Delete</button></a></td>
                        </tr>
                    </c:forEach>


                </table>
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