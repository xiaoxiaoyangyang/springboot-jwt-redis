package com.demo.security.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther guozhiyang
 * @Date 2022-03-10 14:41
 */
public class ResponseUtil {

        /**
         * 获取request
         */
        public static HttpServletRequest getRequest()
        {
            return getRequestAttributes().getRequest();
        }

        /**
         * 获取response
         */
        public static HttpServletResponse getResponse()
        {
            return getRequestAttributes().getResponse();
        }

        /**
         * 获取session
         */
        public static HttpSession getSession()
        {
            return getRequest().getSession();
        }

        public static ServletRequestAttributes getRequestAttributes()
        {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            return (ServletRequestAttributes) attributes;
        }

        /**
         * 将data渲染到客户端
         *
         * @param response
         * @param status
         * @param data
         */
        public static void responseJson(HttpServletResponse response, int status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);

            response.getWriter().write(JSONUtil.toJsonStr(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
