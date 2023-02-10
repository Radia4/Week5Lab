package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author radia
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String logout = request.getParameter("logout");
            HttpSession session = request.getSession();
            
            if (logout != null) {
                session.invalidate();
                request.setAttribute("message", "You have logged out!");
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
                return;
        }
           if (session.getAttribute("username") != null) {
            response.sendRedirect("/Week5Lab_MyLogin/home");
            return;
            }
           
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
            .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         request.setAttribute("username", username);
         request.setAttribute("password", password);
         
         if(username == null || username.equals("") ||
                 password == null || password.equals("")) {
             request.setAttribute("message", "Please enter your username and password");
            
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
                .forward(request, response);
            return;
             
         }
         
         User user = (new AccountService()).login(username, password);
         
         if (user == null) {
             request.setAttribute("message", "Error, Invaild username/password" );
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp" )
                .forward(request, response);
             return;
         }
         
         HttpSession session = request.getSession();
         session.setAttribute("username", username);
         
         response.sendRedirect("/Week5Lab_MyLogin/home");
         return;
       
    }


}
