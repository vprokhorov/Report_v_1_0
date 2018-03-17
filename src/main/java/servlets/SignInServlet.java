package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final AccountService accountService;
    private final DBService dbService;

    public SignInServlet(AccountService accountService, DBService dbService) {
        this.accountService = accountService;
        this.dbService = dbService;
    }

    //get logged user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
//        String sessionId = request.getSession().getId();
//        UserProfile profile = accountService.getUserBySessionId(sessionId);
//        if (profile == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            Gson gson = new Gson();
//            String json = gson.toJson(profile);
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println(json);
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
    }

    //sign in
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

//        if (login == null || pass == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        UserProfile profile = accountService.getUserByLogin(login);
        UserProfile profile = null;
        
        try {
            profile = dbService.getMyUser(login);
            
        } catch (DBException e) {
            e.printStackTrace();
        }
        

        if (profile != null){
            if (profile.getPass().equals(password)){
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Authorized: " + profile.getLogin());
//                 response.getWriter().println("Authorized");

            return;
            }
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().println("Unauthorized");


//        if (profile == null || !profile.getPass().equals(password)) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().println("Unauthorized");
//            return;
//        }
//
//        accountService.addSession(request.getSession().getId(), profile);
//        Gson gson = new Gson();
//        String json = gson.toJson(profile);
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println(json);
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().println("Authorized");
    }

    //sign out
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
//        String sessionId = request.getSession().getId();
//        UserProfile profile = accountService.getUserBySessionId(sessionId);
//        if (profile == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            accountService.deleteSession(sessionId);
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("Goodbye!");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }

    }
}
