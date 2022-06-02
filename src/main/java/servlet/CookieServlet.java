package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Cookie[] cookies = req.getCookies();
        if (cookies == null){
            resp.addCookie(new Cookie("counter", "I"));
            return;
        }
        for(Cookie cookie: cookies){
            if (cookie.getName().equals("counter")){
                final String value = cookie.getValue();
                Cookie respoCookie = new Cookie("counter", value + "I");
                resp.addCookie(respoCookie);
                return;
            }
        }
        resp.addCookie(new Cookie("counter", "I"));
    }
}
