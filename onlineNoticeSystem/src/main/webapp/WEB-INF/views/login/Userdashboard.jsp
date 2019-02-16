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