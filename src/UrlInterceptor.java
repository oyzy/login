import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UrlInterceptor implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(!(httpRequest.getRequestURI().equals("/") || httpRequest.getRequestURI().equals("/login"))){
            String name = "jyt";
            User user = (User) httpRequest.getSession().getAttribute(name);
            if (null == user) {
                httpResponse.sendRedirect("/");
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
