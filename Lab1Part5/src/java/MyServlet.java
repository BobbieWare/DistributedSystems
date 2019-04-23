
/**
 * A servlet that implements a number guessing game.
 *
 * @author Bobbie Ware
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.math.MathContext;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet
{

    private final char QUOTE = '"';

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {  // obtain the session for the client that made the request
        HttpSession session = request.getSession(true); //create if none
        Integer randNum = (Integer) session.getAttribute("counter");
        String message;
        int guess = Integer.parseInt(request.getParameter("guess"));

        if (randNum == null)
        {  // new random number generated
            Random randNums = new Random();
            randNum = randNums.ints(1, 1, 99).findFirst().getAsInt();
            message = "Welcome to the web site";
        }

        if (randNum == guess)
        {  // guess is correct
            message = "Well done you guessed the number!";
        }
        else
        {  // guess is incorrect
            message = "Your guess of " + guess;
            if (randNum > guess)
            {
                message += " was too low";
            }
            else
            {
                message += " was too high";
            }
        }

        session.setAttribute("counter", randNum);
        // set response headers before returning any message content
        response.setContentType("text/html");
        // prepare the content of the response
        String thisURL = "Guess the Number";
        try (PrintWriter pw = response.getWriter())
        {
            pw.println("<!DOCTYPE HTML PUBLIC " + QUOTE
                    + "-//W3C//DTD HTML 4.0 Transitional//EN" + QUOTE + ">\n"
                    + "<HTML>\n" + "<HEAD>\n"
                    + "<TITLE>Guess the Number</TITLE>\n" + "</HEAD>\n" + "<BODY>\n"
                    + "<H1>" + guess + "</H1>\n"
                    + "<P style=\"color:blue;margin-left:20px\">" + message + "</P>\n"
                    + "<form action=\"http://localhost:8080/HelloWeb/SessionTest\">\n"
                    + "<p>Guess:\n"
                    + "<input type=\"text\" name=\"guess\"></p>\n"
                    + "<input type=\"submit\">\n"
                    + "        </form>\n" + "</BODY>\n</HTML>\n");
        }
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}
