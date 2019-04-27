<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>

<html>
    <head>
        <title>Visitor Counter</title>
    </head>
    <body>
        <h1> Task Manager App</h1>
        <hr>

        <%
            Integer hitsCount = (Integer) application.getAttribute("hitCounter");

            if (hitsCount == null || hitsCount == 0) {

                out.println("Welcome to my website!");
                hitsCount = 1;
            } else {

                out.println("Welcome back to my website!");
                hitsCount += 1;
            }
            application.setAttribute("hitCounter", hitsCount);
        %>
    <center>
        <p>Total number of visits: <h1><%= hitsCount%></h1></p>

    <%
        // Set refresh, autoload time as 5 seconds
        response.setIntHeader("Refresh", 5);

        // Get current time
        Calendar calendar = new GregorianCalendar();
        String am_pm;

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        if (calendar.get(Calendar.AM_PM) == 0) {
            am_pm = "AM";
        } else {
            am_pm = "PM";
        }
        String CT = hour + ":" + minute + ":" + second + " " + am_pm;
        out.println("Current Time: " + CT + "\n");
    %>


    <hr>
    &copy; Sohel Shaikh All Right Reserved.
</center>

</body>
</html>