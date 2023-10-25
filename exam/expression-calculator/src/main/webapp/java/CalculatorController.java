import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CalculatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            // Get the expression parameter
            String expressionStr = req.getParameter("expression");

            // mathematical expression builder
            ExpressionBuilder expressionBuilder = new ExpressionBuilder(expressionStr);

            // Add variables from request parameters to the expression
            req.getParameterMap().keySet().forEach(expressionBuilder::variable);

            // Build the expression builder
            Expression expression = expressionBuilder.build();

            // Iterate through request parameters to set variables in the expression
            for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();

                if (values.length > 0) {
                    try {
                        String value = values[0];
                        String reversedValue = req.getParameter(value);

                        // If a reversed value exists, use it instead
                        if (reversedValue != null) {
                            value = reversedValue;
                        }

                        // Set the variable in the expression with a parsed double value
                        expression.setVariable(key, Double.parseDouble(value));
                    } catch (NumberFormatException ignored) {
                        // Ignore parsing errors and continue with the next variable
                    }
                }
            }

            // Evaluate the expression and cast the result to an integer
            int result = (int) expression.evaluate();

            // Print the result to the response
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(result);
            resp.getWriter().flush();
            resp.getWriter().close();
        }
    }
}
