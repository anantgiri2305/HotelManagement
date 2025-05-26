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
public class BookingServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        int roomNo = Integer.parseInt(request.getParameter("roomNo"));

        try (Connection conn = DatabaseConnect.getConnection()) {
            String update = "UPDATE rooms SET status='Occupied' WHERE room_number=?";
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setInt(1, roomNo);
            pst.executeUpdate();

            String insert = "INSERT INTO customers (name, contact, room_number, checkin_date) VALUES (?, ?, ?, CURDATE())";
            PreparedStatement pst2 = conn.prepareStatement(insert);
            pst2.setString(1, name);
            pst2.setString(2, contact);
            pst2.setInt(3, roomNo);
            pst2.executeUpdate();

            response.sendRedirect("rooms");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
