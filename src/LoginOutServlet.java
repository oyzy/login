import javax.naming.Name;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginOutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String userName = req.getParameter("name");
        ServletContext application = super.getServletContext();
        HttpSession session = req.getSession();
        User user = (User) application.getAttribute(userName);
        if (null != user) {
                application.removeAttribute(userName);
                if (null != application.getAttribute(session.getId())) {
                    application.removeAttribute(session.getId());
                    if (null != session.getAttribute(userName)){
                        session.removeAttribute(userName);
                    }
                }
                resp.getWriter().print("success");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
