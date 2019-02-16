<%-- 
    Document   : ADhead
    Created on : Mar 20, 2018, 11:47:10 AM
    Author     : Istiaque && Emran
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>online notice</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />


<spring:url value="/static/css/userLogin.css" var="userLogin" />
<spring:url value="/static/css/font-awesome.min.css" var="font-awesome.min" />

<link href="${font-awesome.min}" rel="stylesheet" />
<link href="${userLogin}" rel="stylesheet" />



<!-- Canonical SEO -->
<link rel="canonical" href="https://www.creative-tim.com/product/light-bootstrap-dashboard-pro" />
<!--     Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<!-- CSS Files -->
<link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/static/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="<%=request.getContextPath()%>/static/css/demo.css" rel="stylesheet" type="text/css"/>

<!--   Core JS Files   -->
<script src="<%=request.getContextPath()%>/static/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/popper.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js" type="text/javascript"></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-switch.js" type="text/javascript"></script>
    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Yno10-YTnLjjn_Vtk0V8cdcY5lC4plU"></script>
    <!--  Chartist Plugin  -->
    <script src="<%=request.getContextPath()%>/static/js/chartist.min.js" type="text/javascript"></script>
    <!--  Notifications Plugin    -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-notify.js" type="text/javascript"></script>
    <!--  Share Plugin -->
    <script src="<%=request.getContextPath()%>/static/js/jquery.sharrre.js" type="text/javascript"></script>
    <!--  jVector Map  -->
    <script src="<%=request.getContextPath()%>/static/js/jquery-jvectormap.js" type="text/javascript"></script>
    <!--  Plugin for Date Time Picker and Full Calendar Plugin-->
    <script src="<%=request.getContextPath()%>/static/js/moment.min.js" type="text/javascript"></script>
    <!--  DatetimePicker   -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
    <!--  Sweet Alert  -->
    <script src="<%=request.getContextPath()%>/static/js/sweetalert2.min.js" type="text/javascript"></script>
    <!--  Tags Input  -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-tagsinput.js" type="text/javascript"></script>
    <!--  Sliders  -->
    <script src="<%=request.getContextPath()%>/static/js/nouislider.js" type="text/javascript"></script>
    <!--  Bootstrap Select  -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-selectpicker.js" type="text/javascript"></script>
    <!--  jQueryValidate  -->
    <script src="<%=request.getContextPath()%>/static/js/jquery.validate.min.js" type="text/javascript"></script>
    <!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
    <script src="<%=request.getContextPath()%>/static/js/jquery.bootstrap-wizard.js" type="text/javascript"></script>
    <!--  Bootstrap Table Plugin -->
    <script src="<%=request.getContextPath()%>/static/js/bootstrap-table.js" type="text/javascript"></script>
    <!--  DataTable Plugin -->
    <script src="<%=request.getContextPath()%>/static/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <!--  Full Calendar   -->
    <script src="<%=request.getContextPath()%>/static/js/fullcalendar.min.js" type="text/javascript"></script>
    <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="<%=request.getContextPath()%>/static/js/light-bootstrap-dashboard.js" type="text/javascript"></script>
    <!-- Light Dashboard DEMO methods, don't include it in your project! -->
    <script src="<%=request.getContextPath()%>/static/js/demo.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/static/js/jquery.table2excel.js" type="text/javascript"></script>