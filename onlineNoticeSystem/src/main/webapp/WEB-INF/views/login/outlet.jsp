<%-- 
    Document   : outlet
    Created on : Mar 21, 2018, 3:20:48 PM
    Author     : Istiaque && Emran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
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
                        <button id="download_excell">download</button>
                        <table class="table table-striped table-dark" id="outletData">
                            <thead>
                            <h4 class="text-center">Outlet</h4>
                            <tr>
                                <th scope="col">SL</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Mobile No</th>
                                <th scope="col">NID No</th>
                                <th scope="col">Business Name</th>
                                <th scope="col">Business Address</th>
                                <th scope="col">Business Category Name</th>
                                <th scope="col">Trade Licence</th>
                                <th scope="col">Trade Licence Photo</th>
                                <th scope="col">Tin No</th>
                                <th scope="col">Entry Date</th>
                                <th scope="col">Update Date</th>
                            </tr>
                            </thead>
                            <tbody id="fivRentECar">
                                <c:forEach items="${outletObj}" var="iteml">
                                    <tr>
                                        <td>${iteml.outlet_id}</td>
                                        <td>${iteml.first_name}</td>
                                        <td>${iteml.last_name}</td>
                                        <td>${iteml.email}</td>
                                        <td>${iteml.mobile_no}</td>
                                        <td>${iteml.nid_no}</td>
                                        <td>${iteml.business_name}</td>
                                        <td>${iteml.business_address}</td>
                                        <td>${iteml.business_category_id}</td>
                                        <td>${iteml.trade_licence}</td>
                                        <td>${iteml.trade_licence_photo}</td>
                                        <td>${iteml.tin_no}</td>
                                        <td>${iteml.entry_on}</td>
                                        <td>${iteml.update_on}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--footer-->
                <%@include file="ADfooter.jsp" %>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(function () {
            var currdate = new Date();
//            var currdate01 = currdate.getDate() + '_' + (currdate.getMonth() + 1) + '_' + currdate.getFullYear();
            var $btnDLtoExcel = $('#download_excell');
            $btnDLtoExcel.on('click', function () {
                $("#outletData").table2excel({
                    exclude: ".noExl",
                    name: "Excel Document Name",
                    filename: "Outlet"+currdate.getFullYear()+"_"+(currdate.getMonth()+1)+"_"+currdate.getDate() ,
                    fileext: ".xls"
                });
            });

        });
    </script>
</html>
