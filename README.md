# HotelManagement

A web-based Hotel Management System built using Java Servlets, JSP, and MySQL, designed to handle admin logins, room check-ins, check-outs, and real-time room status tracking.

## 🚀 Features

- 🔐 Admin login/logout
- 🏠 View room availability and pricing
- ✅ Customer check-in with name and contact
- ❌ Room check-out with auto status update
- 📦 Dynamic room listing with status indicators
- 💡 Session management and Bootstrap-based UI

---

## 🛠️ Technologies Used

- **Backend**: Java (Servlets + JSP)
- **Frontend**: HTML5, CSS3, Bootstrap 5
- **Database**: MySQL
- **Server**: Apache Tomcat
- **IDE**: Eclipse IDE for Enterprise Java Developers
- **JDBC**: MySQL Connector/J


## 📁 Project Structure

HotelManagement/
├── src/
│ └── com.hotel/ # Java Servlets & logic
├── WebContent/
│ ├── login.jsp, rooms.jsp # Web pages
│ ├── WEB-INF/
│ │ ├── web.xml # Servlet configuration
│ │ └── lib/ # JDBC driver
├── mysql-connector-j-9.2.0.jar
└── README.md


## ⚙️ How to Run

1. **Import Project in Eclipse**
   - `File` → `Import` → `Existing Projects into Workspace`
   - Choose your project folder

2. **Create MySQL Database**

3. **Run on Tomcat**
   - Right-click Project → `Run As → Run on Server`

4. **Login**
   - Visit: `http://localhost:8080/HotelManagement/`
   - Username: `admin`, Password: `admin123`
     
     
