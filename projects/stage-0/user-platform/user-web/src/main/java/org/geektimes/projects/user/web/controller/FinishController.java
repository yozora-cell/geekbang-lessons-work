package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * description 注册完成跳转主页
 * program geekbang-lessons-mercyblitz
 *
 * @author yangxiao-lhq
 * @date 2021/3/3 14:34
 **/
@Path("/doRegister")
public class FinishController implements PageController {

    private final UserService userService;

    public FinishController() {
        userService = new UserServiceImpl();
    }

    @Override
    @POST
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"), request.getParameter("phoneNumber"));
        boolean register = userService.register(user);

        if (register) {
            User registerUser = userService.queryUserByNameAndPassword(user.getName(), user.getPassword());
            System.out.println(registerUser);
            request.getSession().setAttribute("title", "注册成功！");
            request.getSession().setAttribute("username", registerUser.getName());
            request.getSession().setAttribute("email", registerUser.getEmail());
        } else {
            request.getSession().setAttribute("title", "注册失败！请稍候重试");
        }
        return "welcome.jsp";
    }
}
