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
        //usunięcie ciastka o nazwie w parametrze "delete"
        String delete = req.getParameter("delete");
        if (delete != null){
            Cookie  cookie = new Cookie(delete, "");
            //maxAge określa czas życia
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            return;
        }
        final Cookie[] cookies = req.getCookies();
        //tworzenie nowego ciastka o nazwie "couter", jeśli brak ciastek w żadaniu
        if (cookies == null){
            resp.addCookie(new Cookie("counter", "I"));
            return;
        }
        //przeglądanie ciastek żądania
        for(Cookie cookie: cookies){
            //szukamy cistka o nazwie "counter"
            if (cookie.getName().equals("counter")){
                final String value = cookie.getValue();
                //tworzymy nowe ciastko o zwiększonej wartości licznika
                Cookie respoCookie = new Cookie("counter", value + "I");
                //dodanie ciastka do odpowiedzi
                resp.addCookie(respoCookie);
                return;
            }
        }
        resp.addCookie(new Cookie("counter", "I"));
    }
}
