package in.csv.csvManipulate.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultitenancyInterceptorHandler extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpResponse<String> publicIpResponse = Unirest.get("http://checkip.amazonaws.com/").asString();
		String publicIp = publicIpResponse.getBody();
		log.info(":::::public Ip Address is : {}", publicIp);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
