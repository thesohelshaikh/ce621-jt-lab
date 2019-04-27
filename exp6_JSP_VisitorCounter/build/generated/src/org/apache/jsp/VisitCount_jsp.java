package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;

public final class VisitCount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Visitor Counter</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1> Task Manager App</h1>\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("        ");

            Integer hitsCount = (Integer) application.getAttribute("hitCounter");

            if (hitsCount == null || hitsCount == 0) {

                out.println("Welcome to my website!");
                hitsCount = 1;
            } else {

                out.println("Welcome back to my website!");
                hitsCount += 1;
            }
            application.setAttribute("hitCounter", hitsCount);
        
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <p>Total number of visits: <h1>");
      out.print( hitsCount);
      out.write("</h1></p>\n");
      out.write("\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("    &copy; Sohel Shaikh All Right Reserved.\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
