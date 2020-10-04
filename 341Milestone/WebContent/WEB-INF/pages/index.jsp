<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>User Information</h2>
<table>
	<tr>
		<th><label>User Name</label></th>
		<th><label>Password</label></th>
	</tr>
	
		<tr>
			<td><label>${user.username}</label></td>
			<td><label>${user.password}</label></td>
		</tr>
	


</table></br>
<div align="center"><a href="logout">logout</a></div>