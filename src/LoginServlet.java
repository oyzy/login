import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet{

    public LoginServlet() {
        super();
    }

    @Override
    public void destroy(){
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.login(name, password);
        if (result) {
            User user = new User(name, password);
            ServletContext application = super.getServletContext();
            User user1 = (User) application.getAttribute(name);
            if (null == user1) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(10);//session过期时间
                session.setAttribute(name,user);
                application.setAttribute(name , user);
                application.setAttribute(session.getId() , session);
                resp.getWriter().print("success,"+name);
            } else {
                resp.getWriter().print("账号已登陆,请先退出再登陆！");
            }
        } else{
            resp.getWriter().print("账号或密码错误！");
        }
    }
}
