<%-- 
    Document   : dashboard
    Created on : Mar 20, 2018, 12:01:48 AM
    Author     : Ahasan Habib Sumon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    <title>profile</title>
        <%@include file="ADhead.jsp" %>
    </head>

    <body>
        <div class="wrapper">
            <!--side bar-->
            <%@include file="UsersideBar.jsp" %>

            <div class="main-panel">
                <!--navbar-->
                <%@include file="ADnavbar.jsp" %>

                <!--body part-->
                <div class="content">
                    <div class="container-fluid">
                    
                    
           
                    
					<table class="table-striped table-dark" style="padding-bottom: 5px;  width: 50%;">
					
						<thead>

							<c:forEach var="info" items="${userInfoList}" varStatus="status">
							
								<tr style="background: whitesmoke; border-top: none; height: 10px ; margin-top: 10px">
									<td style="border-top: none; height: 30px; "> User Name :&nbsp;&nbsp;&nbsp;${info.username}</td>
								</tr>
								
								<tr style="background: whitesmoke;">
									<td style="float: left; height: 30px; padding-bottom: -10px"> Name :&nbsp;&nbsp;&nbsp;${info.firstname}</td>
									<td style="margin-left: -10px; height: 30px; margin-left:7px;  float: left">${info.lastname}</td>
								</tr>
						
								<tr style="background: whitesmoke;">
									<td style="padding-bottom: -50px; height: 30px;"> Phone :&nbsp;&nbsp;&nbsp;${info.phone}</td>
								</tr>
								<tr style="background: whitesmoke;">
									<td style="margin-top: -50px; height: 30px;">Address :&nbsp;&nbsp;&nbsp;${info.address}</td>
								</tr>
								<tr style="background: whitesmoke;">
									<td style="margin-top: -50px; height: 30px;">Gender :&nbsp;&nbsp;&nbsp;${info.gender}</td>
								</tr>
							
							</c:forEach>
						</thead>
						<tbody id="fivRentECar">
						</tbody>
					</table>
					<table class="table table-striped table-dark">
                            <thead>
                            <h4 class="text-center"></h4>
                            
                            </thead>
                            <tbody id="fivOutlet">

                            </tbody>
                        </table>
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