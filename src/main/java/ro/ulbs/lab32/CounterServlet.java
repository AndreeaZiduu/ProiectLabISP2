package ro.ulbs.lab32;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", value = "/CounterServlet")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterGet = (Integer) request.getSession().getAttribute("CounterGetName");
        if (counterGet == null) {
            counterGet = 0;
        }

        String increment = request.getParameter("inc");
        if (increment != null) {
            int valoareI = Integer.parseInt(increment);
            counterGet +=valoareI;
        }

        String decrement = request.getParameter("dec");
        if (decrement != null){
            int valoareD = Integer.parseInt(decrement);
            counterGet -= valoareD;
        }
        if (counterGet == 0){
            request.getSession().setAttribute("WarningGet", true);
        } else {
            request.getSession().removeAttribute("WarningGet");
        }
        request.getSession().setAttribute("CounterGetName", counterGet);
        status(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer counterPost = (Integer) request.getSession().getAttribute("CounterPostName");
        if (counterPost == null) {
            counterPost = 0;
        }
        String increment = request.getParameter("inc");
        if (increment != null) {
            int valoareI = Integer.parseInt(increment);
            counterPost +=valoareI;
        }

        String decrement = request.getParameter("dec");
        if(decrement != null){
            int valoareD = Integer.parseInt(decrement);
            counterPost-= valoareD;
        }
        if (counterPost == 0){
            request.getSession().setAttribute("WarningPost", true);
        } else {
            request.getSession().removeAttribute("WarningPost");
        }

        request.getSession().setAttribute("CounterPostName", counterPost);
        status(request, response);
    }


    private void status(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2>Welcome to Counter Servlet</h2>");
        Integer counterGet = (Integer)
                request.getSession().getAttribute("CounterGetName");
        printWriter.println("<br> Counter for GET: " + counterGet);
        Boolean warningGet = (Boolean) request.getSession().getAttribute("WarningGet");
        if (Boolean.TRUE.equals(warningGet)) {
            printWriter.println("<strong style ='color:red'; '>WARNING GET' </strong>");
        }
        Integer counterPost = (Integer)
                request.getSession().getAttribute("CounterPostName");
        printWriter.println("<br> Counter for POST: " + counterPost);
        Boolean warningPost = (Boolean) request.getSession().getAttribute("WarningPost");
        if (Boolean.TRUE.equals(warningPost)) {
            printWriter.println("<strong style ='color:red'; '>WARNING POST' </strong>");
        }
    }
}