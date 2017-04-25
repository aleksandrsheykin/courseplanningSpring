package main.controllers;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 22.04.2017.
 */
public class ErrorController extends HttpServlet {
    private static Logger logger = Logger.getLogger(ErrorController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
        dispatcher.forward(req, resp);
    }
}
