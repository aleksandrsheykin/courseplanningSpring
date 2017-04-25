package main.controllers;

import main.services.PlanService;
import main.services.PlanServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 19.04.2017.
 */
public class MainController extends HttpServlet {

    private static Logger logger = Logger.getLogger(MainController.class);

    public static PlanService planService = new PlanServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("planList", planService.getAllPlans());
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer deleteId = Integer.parseInt(req.getParameter("deleteId"));
        logger.debug("deleteId="+deleteId);
        if (deleteId != null && deleteId > 0) {
            planService.deletePlanById(deleteId);
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }

}
