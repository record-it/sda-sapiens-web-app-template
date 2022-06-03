package servlet;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UsersVelocityServlet extends VelocityViewServlet {
    @Inject
    UserRepository users;

    @Override
    protected Template handleRequest(HttpServletRequest req, HttpServletResponse resp, Context ctx) {
        ctx.put("users", users.findAllEmails());
        return getTemplate("users.vm");
    }
}
