package org.geektimes.projects.user.web.controller;

import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * description 主页
 * program geekbang-lessons-mercyblitz
 *
 * @author yangxiao-lhq
 * @date 2021/3/3 10:29
 **/
@Path("/")
public class HomeController implements PageController {

    @Override
    @GET
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "index.jsp";
    }
}
