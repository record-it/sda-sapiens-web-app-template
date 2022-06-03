package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/session")
public class SecretFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        final String secret = req.getParameter("secret");
        if (secret == null || !secret.equals("abcd")){
            resp.getWriter().println("Musisz podać secret!!!");
            return;
        }
        filterChain.doFilter(req, resp);
    }
}
