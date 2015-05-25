package edu.train;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.train.shop.UserSession;

public class UserSessionInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
    if (request.getParameter("user") != null) {
      request.setAttribute("userSession", new UserSession(request.getParameter("user")));
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler, ModelAndView modelAndView)
      throws Exception {
    UserSession userSession = (UserSession) request.getAttribute("userSession");
    if (userSession == null || modelAndView == null) {
      return;
    }
    if ((modelAndView.getViewName() == "shop/add-product") && !userSession.canAddProducts()) {
      modelAndView.setViewName("access-error");
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
      HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
  }

}
