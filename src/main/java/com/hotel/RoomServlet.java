package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RoomServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Room> rooms = new ArrayList<>();
		try (Connection conn = DatabaseConnect.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM rooms")) {

			while (rs.next()) {
				Room room = new Room(rs.getInt("room_number"), rs.getString("type"), rs.getString("status"),
						rs.getDouble("price"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		request.setAttribute("rooms", rooms);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rooms.jsp");
		dispatcher.forward(request, response);
	}
}
