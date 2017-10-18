import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name="ListAdsServlet", urlPatterns = "/ads")
public class ListAdsServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Ads ads = DaoFactory.getAdsDao();
        request.setAttribute("ads", ads.all());
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
