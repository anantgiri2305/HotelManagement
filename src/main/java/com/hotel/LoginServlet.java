package com.hotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try (Connection conn = DatabaseConnect.getConnection()) {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", username);
				response.sendRedirect("rooms");
			} else {
				response.sendRedirect("login.jsp?error=1");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
