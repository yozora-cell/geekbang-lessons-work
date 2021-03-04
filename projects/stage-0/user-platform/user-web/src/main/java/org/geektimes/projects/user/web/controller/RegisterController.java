package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * description 注册控制器
 * program geekbang-lessons-mercyblitz
 *
 * @author yangxiao-lhq
 * @date 2021/3/3 10:31
 **/
@Path("/register")
public class RegisterController implements PageController {

    @Override
    @GET
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "register-form.jsp";
    }


}
