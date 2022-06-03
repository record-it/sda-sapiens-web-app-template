package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final PrintWriter writer = resp.getWriter();
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html");
//        writer.println("<html><body><h1>Dokument HTML</h1></body></html>");
        String valueOfParameterName = req.getParameter("name");
        req.setAttribute("name", valueOfParameterName);
        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        //req.getRequestDispatcher("/hello.jsp").include(req, resp);
    }
}
