package pk.GradeBook.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pk.GradeBook.util.Roles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessLoginHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        // TODO: 1 iteration o.o
        for(GrantedAuthority auth : authentication.getAuthorities()){
            if(Roles.ROLE_STUDENT.equals(auth.getAuthority())){
                httpServletResponse.sendRedirect("student/events");
                // student/eventsManagement is a main students main page
            }
            if(Roles.ROLE_TEACHER.equals(auth.getAuthority())){
                httpServletResponse.sendRedirect("/teacher");
                }
            if(Roles.ROLE_ADMIN.equals(auth.getAuthority())){
                httpServletResponse.sendRedirect("/admin");
                }
        }
    }
}
