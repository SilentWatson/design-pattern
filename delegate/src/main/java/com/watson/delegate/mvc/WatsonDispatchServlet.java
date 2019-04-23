package com.watson.delegate.mvc;

import com.watson.delegate.mvc.controller.MemberController;
import com.watson.delegate.mvc.controller.OrderController;
import com.watson.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class WatsonDispatchServlet extends HttpServlet {
    private List<Handler> handlers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Class<?> memberControllerClass = MemberController.class;
        try {
            handlers.add(new Handler().setController(memberControllerClass.newInstance()).setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class})).setUrl("/web/getMemberById.json"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

//    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
//        String uri = req.getRequestURI();
//        String mid = req.getParameter("mid");
//        if("getMemberById".equals(uri)){
//            new MemberController().getMemberById(mid);
//        }else if("getOrderById".equals(uri)) {
//            new OrderController().getOrderById(mid);
//        }else if("logout".equals(uri)) {
//            new SystemController().logout();
//        }else{
//            try {
//                resp.getWriter().write("404 not found");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h: handlers ) {
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }
        try{
            Object obj = handler.getMethod().invoke(handler.controller,req.getParameter("mid"));
            resp.getWriter().write(obj.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
