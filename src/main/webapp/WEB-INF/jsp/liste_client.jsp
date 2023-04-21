<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page import="com.aina.spring_mvc.model.Commune" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aina.spring_mvc.model.Article_Event" %><%--
  Created by IntelliJ IDEA.
  User: aina
  Date: 2023-01-11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Article_Event> communes = (List<Article_Event>) request.getAttribute("data");
    int section=(int)request.getAttribute("section");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

    <title>Our Offer</title>
    <!-- Loading third party fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,600,700" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/theme/alef/fonts/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <!-- Loading main css file -->
    <link rel="stylesheet" href="<c:url value="/resources/theme/alef/animate.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/theme/alef/style.css"/>">

    <!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/alef/js/ie-support/html5.js"/>"></script>
  <script src="<c:url value="/resources/theme/alef/js/ie-support/respond.js"/>"></script>
  <![endif]-->
</head>
<body>

<div id="site-content">

    <header class="site-header wow fadeInDown">
        <div class="container">
            <div class="header-content">
                <div class="branding">
                    <img src="<c:url value="/resources/theme/alef/images/logo.png"/>" alt="Company Name" class="logo">
                    <h1 class="site-title"><a href="index.html">Company Name</a></h1>
                    <small class="site-description">Tagline goes here</small>
                </div>

                <nav class="main-navigation">
                    <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
                    <ul class="menu">
                        <li class="menu-item"><a href="about-us.html">About us</a></li>
                        <li class="menu-item  current-menu-item"><a href="our-offer.html">Our Offer</a></li>
                        <li class="menu-item"><a href="customer-protection.html">Customer Protection</a></li>
                        <li class="menu-item"><a href="contact.html">Contact</a></li>
                    </ul>
                </nav>

                <div class="social-links">
                    <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                    <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                    <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
                    <a href="#" class="pinterest"><i class="fa fa-pinterest"></i></a>
                </div>
            </div>
            <nav class="breadcrumbs">
                <a href="index.html">Home</a> &rarr;
                <span>Our Offer</span>
                <form action="search" method="get">
                    <input type="text" name="re">
                    <input type="submit" value="search">
                </form>
            </nav>
        </div>
    </header> <!-- .site-header -->

    <main class="content">
        <div class="fullwidth-block">
            <div class="container">
                <div class="filterable-items">
                    <% for (Article_Event commune : communes) { %>
                    <% if(commune.getEtat()==2) {%>
                    <div class="filterable-item south-america">
                        <article class="offer-item">
                            <figure class="featured-image">
                                <img src="<%= commune.getSary() %>">
                            </figure>
                            <% if(commune.getId_type()==2) {%>
                            <h2 class="entry-title" style="color: blue"><a href="#"><%= commune.getTitre() %></a></h2>
                            <%}%>
                            <%if(commune.getId_type()==1) {%>

                            <h2 class="entry-title" style="color: black"><a href="#"><%= commune.getTitre() %></a></h2>
                            <%}%>

                            <p><%= commune.getAbout() %></p>
                            <strong><%= commune.getDate1() %></strong>
                            <small><%= commune.getDate2() %></small>
                        </article>
                        <%}%>
                    </div>
                    <%  } %>
                </div>

                <div class="pagination wow fadeInUp">
                    <% for (int i = 0; i < section; i++) { %>
                    <span class="page-numbers current"> <a href="get_all_for_client?limite=<%=i%>"><%=i+1%></a></span>
                    <%}%>
                </div>

            </div>

        </div>


    </main> <!-- .content -->

    <footer class="site-footer wow fadeInUp">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="widget">
                            <h3 class="widget-title">About us</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus animi asperiores magnam ducimus laboriosam soluta, odio doloribus, voluptas numquam facilis consectetur nam in repudiandae commodi odit iste sed doloremque repellat.</p>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="widget">
                            <h3 class="widget-title">Helpful Links</h3>
                            <ul class="list-arrow">
                                <li><a href="#">Labore et dolore magnam</a></li>
                                <li><a href="#">Dolore magnam</a></li>
                                <li><a href="#">Magnam Labore et</a></li>
                                <li><a href="#">Dolore mabore magnam</a></li>
                                <li><a href="#">Et dolore magnam</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="widget">
                            <h3 class="widget-title">Helpful Links</h3>
                            <ul class="list-arrow">
                                <li><a href="#">Labore et dolore magnam</a></li>
                                <li><a href="#">Dolore magnam</a></li>
                                <li><a href="#">Magnam Labore et</a></li>
                                <li><a href="#">Dolore mabore magnam</a></li>
                                <li><a href="#">Et dolore magnam</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="widget widget-customer-info">
                            <h3 class="widget-title">Customer Service</h3>
                            <img src="<c:url value="/resources/theme/alefa/dummy/footer-customer-service.jpg"/>" alt="" class="pull-left">
                            <div class="cs-info">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim voluptates pariatur vero.</p>
                                <p>+1 421 458 321 <br> <a href="mailto:cs@companyname.com">cs@companyname.com</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="branding pull-left">
                    <img src="images/logo-footer.png" alt="Company Name" class="logo">
                    <h1 class="site-title"><a href="index.html">Company Name</a></h1>
                    <small class="site-description">Tagline goes here</small>
                </div>

                <div class="contact-links pull-right">
                    <a href="https://goo.gl/maps/oQKxg"><i class="fa fa-map-marker"></i> 983 Avenue Street, New York</a>
                    <a href="tel:+134453455345"><i class="fa fa-phone"></i> +1 344 5345 5345</a>
                    <a href="mailto:contact@companyname.com"><i class="fa fa-envelope"></i> contact@companyname.com</a>
                </div>
            </div>
        </div>
        <div class="colophon">
            <div class="container">
                <p class="copy">Copyright 2014 Company Name, Designed by Themezy, All right reserved.</p>
            </div>
        </div>
    </footer> <!-- .site-footer -->

</div> <!-- #site-content -->
<script src="<c:url value="/resources/theme/alef/js/jquery-1.11.1.min.js"/>"></script>
<script src="<c:url value="/resources/theme/alef/js/min/plugins-min.js"/>"></script>
<script src="<c:url value="/resources/theme/alef/js/min/app-min.js"/>"></script>

</body>

</html>