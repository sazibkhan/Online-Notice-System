<%-- 
    Document   : dashboard
    Created on : Mar 20, 2018, 12:01:48 AM
    Author     : Istiaque && Emran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    <title>add notice</title>
        <%@include file="ADhead.jsp" %>
    </head>

    <body>
        <div class="wrapper">
            <!--side bar-->
            <%@include file="ADsideBar.jsp" %>

            <div class="main-panel">
                <!--navbar-->
                <%@include file="ADnavbar.jsp" %>

                <!--body part-->
                <div class="content">
                    <div class="container-fluid">
                    
                   
                    
                     <form:form id="regForm" modelAttribute="notice" action="addnotice" method="post" >
                  			<div class="form-body form-body-info">

							

							<div class=" valid-form" style="margin-bottom: -20px">
												<form:hidden path="id" />
											 <span class="help-block" style="margin-right: -30px">Notice Title</span>
												 <form:input path="notice_title" name="username" id="name"  style="width: 30%; height:15% "/>
											</div>
											
											<span class="help-block"  >Notice </span>
											<div class=" valid-form" >
											
												 <form:textarea path="notice" name="username" rows="5" cols="60"/>
											</div>
									
										<div class="" style="margin-left: -30px; margin-top: -20px">
											<div class="radio" id="name" style="">
												<form:label path="valueable">valueble</form:label>
												<form:radiobutton path="valueable" value="1" label="yes" />
												<form:radiobutton path="valueable" value="0" label="no" />
												
											</div>
										</div>

										<div>
												<form:button id="register" name="register"  class="button">notice</form:button>
											</div>
											
											<div class="clearfix"> 
												
													</div>
									
									</div>
                  
                    
                    </form:form>
                    
                        
                    </div>
                </div>
                
                  
                 
                        
                <!--footer-->
                <%@include file="ADfooter.jsp" %>
            </div>
        </div>
    </body>
    
    <script type="text/javascript">
        $(document).ready(function () {
//                demo.initDashboardPageCharts();
//                demo.showNotification();
//                demo.initVectorMap();
            call_outlet();
            call_rentcar();
            function call_rentcar() {
                $.ajax({
                    url: "<%=request.getContextPath()%>/dashboard/getLastFivRenteCar",
                    dataType: "json",
                    type: 'GET',
                    success: function (data) {
                        setRentECarData(data);
                    }
                });
            }
//            }, 20000);//time in milliseconds 
            function setRentECarData(data) {
                var len = data.length;
                var row = "";
                $("#fivRentECar").empty();
//                alert(len);
                for (i = 0; i < len; i++) {
                    row += "<tr><td>" + data[i].first_name + "</td><td>" + data[i].email + "</td><td>" + data[i].business_name + "</td><td>" + data[i].business_address + "</td></tr>";
                }
                $("#fivRentECar").append(row);
            }
            function call_outlet() {
                $.ajax({
                    url: "<%=request.getContextPath()%>/dashboard/getLastFivOutlate",
                    dataType: "json",
                    type: 'GET',
                    success: function (data) {
                        setOutletData(data);
                    }
                });
            }
            function setOutletData(data) {
                var len = data.length;
                var row = "";
//                alert(len);
                $("#fivOutlet").empty();
                for (i = 0; i < len; i++) {
                    row += "<tr><td>" + data[i].first_name + "</td><td>" + data[i].email + "</td><td>" + data[i].business_name + "</td><td>" + data[i].business_address + "</td></tr>";
                }
                $("#fivOutlet").append(row);
            }
            setTimeout(call_outlet(), 20000)
            setTimeout(call_rentcar()(), 20000)

        });
    </script>
</html>