<!-- Austin Rivard - CS157A w/ Prof. Mike Wu - 09/20/2022 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %> 
<html> 
    <head> 
        <title>JDBC Connection example</title> 
    </head>
    <body> 
        <h1>JDBC Connection example</h1> 
        <% 
        String db = "db";
        String user = "root";
        String password = "password";
        try { 
            java.sql.Connection con; 
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password); 
            out.println("Successfully opened database: '" + db + "'."); 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from db.USERS");
            while(rs.next())
                out.println("<br>" + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            con.close(); 
        } catch(SQLException e) { 
            out.println("SQLException caught: " + e.getMessage());
        } 
        %> 
    </body> 
</html> 