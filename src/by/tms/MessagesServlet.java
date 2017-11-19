package by.tms;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagesServlet extends HttpServlet {
    @Override
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if(ForumServlet.themeMsgs[Integer.valueOf(ForumServlet.theme)-1].size()>0) {
            for (Message message : ForumServlet.themeMsgs[Integer.valueOf(ForumServlet.theme)-1]) {
                out.println("<p>" + message.getUser() + " [" + message.getMsgDate() + "]: " + message.getMessage() + "</p><br>");
            }
        }
        out.println("<a href=\"" + request.getServletContext().getContextPath() + "/index.jsp\">Go To Index Page</a>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }


}
