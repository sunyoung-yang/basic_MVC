package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//servlet을 사용하기 위해선 스프링 부트에 내장되어 있는 httpServlet을 상속받아야 한다.
//서블렛은 http메시지를 파악하고 tcp 대기 등 메시지 처리의 전반적인 역할을 함
//url에서 /hello로 http메시지보내면 httpServlet이란 이름의 서블렛이 메시지 처리
@WebServlet(name="httpServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    //서블릿이 실행되면 서비스 메서도가 호출된다.
    //요청이 오면 서블릿 컨테이너(was)가 request, response객체를 만들어 서블릿에 던져줘
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); //soutm
        System.out.println("request: " + request); //soutv
        System.out.println("response: "+ response);

        String username = request.getParameter("username"); //ctrl+alt+v
        System.out.println("username = " + username); //서블릿은 메시지 파싱(끊어서 해석)도 해준다는 걸 알 수 있다.

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("here response " + username); //http바디에 데이터 들어가
    }
}
