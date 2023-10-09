package org.seariver.kanbanboard.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Interceptor, registrar información de solicitudes HTTP
public class HttpLoggerInterceptor extends HandlerInterceptorAdapter {

    private Logger logeado= LoggerFactory.getLogger(this.getClass());

    //Este método se ejecuta antes de que la solicitud HTTP llegue al controlador al que está dirigida.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //Verificación
        if (logeado.isInfoEnabled()) {
            logeado.info("REQUEST::{}:{}",
                request.getMethod(),
                request.getRequestURI());
        }

        return true;
    }
}
