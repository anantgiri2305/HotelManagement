<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.hotel.Room"%>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rooms</title>
<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg-light">
	<div class="container mt-4">
		<div class="d-flex justify-content-between align-items-center mb-4">
			<h3>Room List</h3>
			<a href="logout" class="btn btn-danger">Logout</a>
		</div>
		<table class="table table-bordered table-hover">
			<thead class="table-dark">
				<tr>
					<th>Room No</th>
					<th>Type</th>
					<th>Status</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
            List<Room> rooms = (List<Room>) request.getAttribute("rooms");
            for (Room r : rooms) {
        %>
				<tr>
					<td><%= r.getNumber() %></td>
					<td><%= r.getType() %></td>
					<td><%= r.getStatus() %></td>
					<td>₹<%= r.getPrice() %></td>
					<td>
						<% if ("Vacant".equals(r.getStatus())) { %>
						<form action="book" method="post" class="d-flex flex-wrap gap-2">
							<input type="hidden" name="roomNo" value="<%= r.getNumber() %>">
							<input type="text" name="name" placeholder="Name" required
								class="form-control form-control-sm" /> <input type="text"
								name="contact" placeholder="Contact" required
								class="form-control form-control-sm" />
							<button type="submit" class="btn btn-success btn-sm">Check-In</button>
						</form> <% } else { %>
						<form action="checkout" method="post">
							<input type="hidden" name="roomNo" value="<%= r.getNumber() %>">
							<button type="submit" class="btn btn-warning btn-sm">Check-Out</button>
						</form> <% } %>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>