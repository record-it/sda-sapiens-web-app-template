package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    public static final String PARAM_A = "a";
    public static final String PARAM_B = "b";
    public static final String PARAM_OPERATOR = "operator";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String strA = req.getParameter(PARAM_A);
        //przykład odczytu z mapy parametrów
        final String[] strings = req.getParameterMap().get(PARAM_B);
        if (strings.length != 1){
            return;
        }
        final String strB = strings[0];
        final String operator = req.getParameter(PARAM_OPERATOR);
        final PrintWriter writer = resp.getWriter();
        if(strA == null || strB == null || operator == null){
            writer.println("Brak właściwych parametrów!");
            return;
        }
        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            switch (operator){
                case "add":
                    writer.println(a + b);
                    break;
                default:
                    writer.println("Nieznany operator: " + operator);
            }
        }catch (NumberFormatException e){
            writer.println("Błąd formatu danych!");
        }
    }
}
