<%-- 
    Document   : ADhead
    Created on : Mar 20, 2018, 11:47:10 AM
    Author     : Istiaque && Emran
--%>
<!--side bar-->
<div class="sidebar" data-color="orange"
	data-image="http://demos.creative-tim.com/light-bootstrap-dashboard-pro/assets/img/sidebar-5.jpg">
	<!--
Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

Tip 2: you can also add an image using data-image tag
    -->
	<div class="sidebar-wrapper">
		<div class="logo">
		<a href="#" class="simple-text logo-normal">  &nbsp; &nbsp; &nbsp; &nbsp;online notice</a>
		</div>
		<div class="user">
			
		</div>
		<ul class="nav">
			<%-- <li class="nav-item "><a class="nav-link"
				href="addnotice"> <i
					class="nc-icon nc-chart-pie-35"></i>
					<p>Add Notice</p> <!--                    <form method="post" action="<%=request.getContextPath()%>/AdminLoginForm">
                        <input type="submit" value="Dashboard" class="link"/>
                    </form>-->
			</a></li> --%>
			<li class="nav-item"><a class="nav-link"
				href="shownotice"> <i
					class="nc-icon nc-email-83"></i>
					<p>
						Show Notice
						<!--<b class="caret"></b>-->
					</p>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				 href="important"> <i
					class="nc-icon nc-email-85"></i>
					<p>
							Important
						<!--<b class="caret"></b>-->
					</p>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				 href="userInfo"> <i
					class="nc-icon nc-grid-45"></i>
					<p>
						Profile
						<!--<b class="caret"></b>-->
					</p>
			</a></li>
		</ul>
	</div>
</div>