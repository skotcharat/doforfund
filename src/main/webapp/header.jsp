<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/16/20
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="site-wrap">

    <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>




    <header class="site-navbar py-3 border-bottom" role="banner">

        <div class="container-fluid">
            <div class="row align-items-center">

                <div class="col-6 col-xl-2" data-aos="fade-down">
                    <h1 class="mb-0"><a href="index.jsp" class="text-black h2 mb-0">DoforFund</a></h1>
                </div>
                <div class="col-10 col-md-8 d-none d-xl-block" data-aos="fade-down">
                    <nav class="site-navigation position-relative text-right text-lg-center" role="navigation">

                        <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                            <li><a href="index.jsp">Home</a></li>
                            <li class="active"><a href="about.jsp">About Us</a></li>
                            <li class="active"><a href="howItWorks.jsp">How It Works</a></li>
                            <li  class="active"><a href="displayEvent">Event</a></li>
                            <li class="has-children">
                                <a href="gallery.jsp">Gallery</a>
                                <ul class="dropdown">
                                    <li><a href="https://drive.google.com/drive/folders/17dePQfVGUFUZMAHkWjDyenqerowAqEsx?usp=sharing">Nature</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1gmuIASFVc7PcpT5112jV-d77QFTiU42v?usp=sharing">Portrait</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1vz7JGWWEFpUrmTmPplH3EMAN6MnQexuq?usp=sharing">People</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1a6Oba41KueTWE07oFyJMxLrLlQx3vcnl?usp=sharing">Architecture</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1ZqJ01n0ubsj1evkQ_50ND2V_5uisTg4b?usp=sharing">Animals</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1O_0hlS5QOpngYvdL7fOTBrdmM92uKNkH?usp=sharing">Baby</a></li>
                                    <li><a href="https://drive.google.com/drive/folders/1YYlZsTixYYOq2lUaS0XW2NZYNjdytou1?usp=sharing">Travel</a></li>
                                    
                                </ul>
                            </li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="donate.jsp"><button class="btn btn-primary py-2 px-4 text-white">DONATION</button></a></li>
                        </ul>
                    </nav>
                </div>

                <div class="col-6 col-xl-2 text-right" data-aos="fade-down">
                    <div class="d-none d-xl-inline-block">
                        <ul class="site-menu js-clone-nav ml-auto list-unstyled d-flex text-right mb-0" data-class="social">
                            <li>
                                <c:choose>
                                    <c:when test="${(pageContext.request.isUserInRole('admin')) ||
                                    (pageContext.request.isUserInRole('user'))}">
                                        <a href="logout.jsp" class="pl-0 pr-3" class="btn btn-primary py-2 px-4 text-white">Logout</a>
                                        <p class="usernameHeader">Welcome : <%= request.getRemoteUser()%></p>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="loginRealm.jsp" class="pl-0 pr-3" class="btn btn-primary py-2 px-4 text-white">Sign in</a>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                            <li>

                            </li>
                            <li>
                                <a href="signupAction"><button class="btn btn-primary py-2 px-4 text-white">Sign up</button></a>
                            </li>
                        </ul>

                    </div>

                    <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

                </div>

            </div>
        </div>

    </header>
</div>