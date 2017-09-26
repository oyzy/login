import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;



public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String sessionId = httpSessionEvent.getSession().getId();
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        HttpSession session = (HttpSession) context.getAttribute(sessionId);
        if (null != session) {
            context.removeAttribute(sessionId);
            Enumeration<String> sessionattributeNames = session.getAttributeNames();
            while (sessionattributeNames.hasMoreElements()) {
                String name = sessionattributeNames.nextElement();
                if (null != context.getAttribute(name)){
                    context.removeAttribute(name);
                }
            }

        }
    }
}
