package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CheckoutServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomNo = Integer.parseInt(request.getParameter("roomNo"));

		try (Connection conn = DatabaseConnect.getConnection()) {
			PreparedStatement pst = conn.prepareStatement("UPDATE rooms SET status='Vacant' WHERE room_number=?");
			pst.setInt(1, roomNo);
			pst.executeUpdate();

			PreparedStatement pst2 = conn.prepareStatement(
					"UPDATE customers SET checkout_date=CURDATE() WHERE room_number=? AND checkout_date IS NULL");
			pst2.setInt(1, roomNo);
			pst2.executeUpdate();

			response.sendRedirect("rooms");
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
