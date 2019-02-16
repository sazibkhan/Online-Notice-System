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
    <title>all notice</title>
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
                    <div class="container-fluid" style="style="width: 35%;"">
                    
                  <form:form onsubmit="shownotice" modelAttribute="searchAttribute" method="post" class="navbar-form navbar-left navbar-search-form"
					role="search">
					<div class="input-group" style="width: 50%">
						<form:input type="text" path="search"
							class="form-control" placeholder="please search your institute..." 
							style="margin-top: 2%;
background: burlywood;
color: black;
height: 30px;
width: 200px;
border-radius: 7px !important;" />
					</div>
				</form:form>
                    
                    
                        <table class="table table-striped table-dark">
                            <thead>
                           
                       
							

			<c:forEach var="notice" items="${listNotice}" varStatus="status">
				<tr  style="background: whitesmoke;">
				<td style="float: left;background: whitesmoke;"><img src="Picture/${notice.photoPath}"
											style="height: 40px; width: 50px; border-radius: 50px;"/></td>
				<td style="float: left;">${notice.admin_name}</td>
				
				</tr>
				<tr  style="background: whitesmoke; ">
				<td style="float: left">${notice.notice_title}</td>
					<td style="float: left">${notice.create_date}</td>
				</tr>
				
				<tr>
					<td style="border: none !important;">${notice.notice}</td>
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