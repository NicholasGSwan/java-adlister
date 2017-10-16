import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="fillArray", urlPatterns = "/fillArray")
public class fillArray extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String stringToRepeat;
        int cols;
        int rows;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (req.getParameter("fill") != null && req.getParameter("cols") != null && req.getParameter("rows")==null) {
            stringToRepeat = req.getParameter("fill");
            cols = Integer.parseInt(req.getParameter("cols"));
            String finalFill = stringToHtml(stringToRepeat, cols);
            out.println("<h1>Look at the table!</h1><table>" + finalFill + "</table>");
        }else if(req.getParameter("fill") != null && req.getParameter("cols") != null && req.getParameter("rows")!=null){
            stringToRepeat = req.getParameter("fill");
            cols = Integer.parseInt(req.getParameter("cols"));
            rows = Integer.parseInt(req.getParameter("rows"));
            String finalFill = stringToHtml(stringToRepeat, rows, cols);
            out.println("<h1>Look at the table!</h1><table>" + finalFill + "</table>");
        } else{
            out.println("<h1>Nothing to print in the table...</h1>");

        }
    }
    protected String stringToHtml(String fill,int columns ){
        return stringToHtml(fill, 1, columns);
    }


    protected String stringToHtml(String fill, int rows,int columns ){
        String stringToReturn = "";
        for(int j = 0; j<rows; j++) {
            stringToReturn += "<tr>";
            for (int i = 0; i < columns; i++) {
                stringToReturn += "<td>" + fill + "</td>";
            }
            stringToReturn += "</tr>";
        }
        return stringToReturn;
    }

}
