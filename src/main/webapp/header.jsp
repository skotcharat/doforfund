<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/16/20
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
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
                            <li  class="active">><a href="event.jsp">Event</a></li>
                            <li class="has-children">
                                <a href="single.jsp">Gallery</a>
                                <ul class="dropdown">
                                    <li><a href="#">Nature</a></li>
                                    <li><a href="#">Portrait</a></li>
                                    <li><a href="#">People</a></li>
                                    <li><a href="#">Architecture</a></li>
                                    <li><a href="#">Animals</a></li>
                                    <li><a href="#">Sports</a></li>
                                    <li><a href="#">Travel</a></li>
                                    <li class="has-children">
                                        <a href="#">Sub Menu</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Menu One</a></li>
                                            <li><a href="#">Menu Two</a></li>
                                            <li><a href="#">Menu Three</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="danate.jsp"><button class="btn btn-primary py-2 px-4 text-white">DONATION</button></a></li>
                        </ul>
                    </nav>
                </div>

                <div class="col-6 col-xl-2 text-right" data-aos="fade-down">
                    <div class="d-none d-xl-inline-block">
                        <ul class="site-menu js-clone-nav ml-auto list-unstyled d-flex text-right mb-0" data-class="social">
                            <li>
                                <a href="#" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                            </li>
                            <li>
                                <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                            </li>
                            <li>
                                <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                            </li>
                            <li>
                                <a href= 'loginAction'><button class="btn btn-primary py-2 px-4 text-white">Log in</button></a>
                                <c:if test="${pageContext.request.isUserInRole('admin')}">

                                    <a href="search.jsp">login</a>

                                </c:if>
                            </li>
                        </ul>

                    </div>

                    <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

                </div>

            </div>
        </div>

    </header>