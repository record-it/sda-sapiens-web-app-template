package servlet;

import repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Inject
    UserRepository users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("user");
        if (email == null){
            resp.getWriter().println("Musisz podać użytkownika");
        }
        //final String checkUser = (String) session.getAttribute("user");
        final String user = users.findUserByEmail(email);
        if (user == null){
            resp.getWriter().println("Nie jesteś zarejestrowany");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
    }
}
