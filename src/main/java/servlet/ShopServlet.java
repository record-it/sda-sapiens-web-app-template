package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product = req.getParameter("product");
        final HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null){
            resp.getWriter().println("Musisz się najpierw zarejestrować na /session");
            return;
        }
        String user = (String) session.getAttribute("user");
        if (product == null){
            final String cart = (String) session.getAttribute("cart");
            resp.getWriter().println("Nie wybrałeś produktu, "
                    + user +" ! Na razie masz w koszyku " + cart);

            return;
        }
        session.setAttribute("cart", product);
    }
}
