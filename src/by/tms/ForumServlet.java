package by.tms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@WebServlet("/forum")
public class ForumServlet extends HttpServlet {
    //public static final ArrayList<Message> messages = new ArrayList<>();
    public static final ArrayList<Message>[] themeMsgs = new ArrayList[3];
    public static String theme = "";

    public ForumServlet() {
        themeMsgs[0]=new ArrayList<>();
        themeMsgs[1]=new ArrayList<>();
        themeMsgs[2]=new ArrayList<>();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String msg = req.getParameter("message");
        this.theme = req.getParameter("theme");
        if(user!=null && msg!=null) {
            if (user.length() > 0 && msg.length() > 0) {
                Message m = new Message(user, msg, new Date(System.currentTimeMillis()));
                themeMsgs[Integer.valueOf(theme)-1].add(m);
            }
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js\"></script>");
        out.println("<script> function show() { $.ajax({ url: \"msg.jsp\", cache: false, success: function(html){ $(\"#content\").html(html); } }); } $(document).ready(function(){ show(); setInterval('show()',1000); }); </script></head>");
        out.println("<body>");
        out.println("Theme "+theme+"<hr>");
        out.println("<div id=\"content\"></div> ");
        out.println("<hr>");
        out.println("<form action=\"/forum?theme="+theme+"\" method=\"post\">");
        out.println("<input type=\"text\" name=\"user\" />");
        out.println("<input type=\"text\" name=\"message\" />");
        out.println("<input type=\"submit\" value=\"Send\" />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
