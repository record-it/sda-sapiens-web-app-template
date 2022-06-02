package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String queryString = req.getQueryString();
        final Enumeration<String> parameterNames = req.getParameterNames();
        String result = "";
        while(parameterNames.hasMoreElements()){
            result += parameterNames.nextElement() + " ";
        }
        final Map<String, String[]> parameterMap = req.getParameterMap();
        final PrintWriter writer = resp.getWriter();
        writer.println("Query string: " + queryString);
        writer.println("Parameteres names: " + result);
        result ="";
        for(Map.Entry<String, String[]> entry: parameterMap.entrySet()){
            result += entry.getKey() + " " + Arrays.toString(entry.getValue())+", ";
        }
        writer.println("Values: " + result);
        writer.println("Parameter a: " + req.getParameter("a"));
    }
}
