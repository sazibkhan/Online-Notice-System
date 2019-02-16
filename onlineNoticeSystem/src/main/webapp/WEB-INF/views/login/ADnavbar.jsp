
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<nav class="navbar navbar-expand-lg ">
    <div class="container-fluid">
		<div class="navbar-wrapper">
			<div class="navbar-minimize">
				<button id="minimizeSidebar"
					class="btn btn-warning btn-fill btn-round btn-icon d-none d-lg-block">
					<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i> <i
						class="fa fa-navicon visible-on-sidebar-mini"></i>
				</button>
			</div>
			<a class="navbar-brand" href="#pablo">Online notice </a>
		</div>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" aria-controls="navigation-index"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-bar burger-lines"></span> <span
				class="navbar-toggler-bar burger-lines"></span> <span
				class="navbar-toggler-bar burger-lines"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="nav navbar-nav mr-auto">
				      

			</ul>
			<ul class="navbar-nav">
				
				</a>
					
				
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="http://example.com"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <i
						class="nc-icon nc-bullet-list-67"></i>
				</a>
					<div id="logoutDg" class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownMenuLink">
						 <a href="<%=request.getContextPath()%>/logout" class="dropdown-item text-danger"> <i
							class="nc-icon nc-button-power"></i> Log out
						</a>
					</div></li>
			</ul>
		</div>
	</div>
</nav>
<script>
function logout(){

document.getElementById("logoutDg").style.display="block";
}

</script>

</body>
</html>