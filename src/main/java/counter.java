import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="CounterServlet", urlPatterns = "/counter")
public class counter extends HttpServlet {
    private int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        boolean reset;
        reset = Boolean.valueOf(req.getParameter("reset"));
        if(reset){
            counter = 1;
        }else {
            counter++;
        }
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("Views: "+counter);

    }

}
