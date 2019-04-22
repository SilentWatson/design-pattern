package com.watson.delegate.mvc;

import com.watson.delegate.mvc.controller.MemberController;
import com.watson.delegate.mvc.controller.OrderController;
import com.watson.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WatsonDispatchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");
        if("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }else if("getOrderById".equals(uri)) {
            new OrderController().getOrderById(mid);
        }else if("logout".equals(uri)) {
            new SystemController().logout();
        }else{
            try {
                resp.getWriter().write("404 not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
