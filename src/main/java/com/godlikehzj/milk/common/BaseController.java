package com.godlikehzj.milk.common;

import com.godlikehzj.milk.util.ResponseEntity;
import com.godlikehzj.milk.util.SysApiStatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by godlikehzj on 15/9/9.
 */
public abstract class BaseController {
    public static String EXCEPTION_JSON = "{\"status\":\"%s\",\"message\":\"%s\"}";

    /**
     * 拦截器异常错误信息
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request, PrintWriter print) {
        e.printStackTrace();
        if (print != null) {
            print.print(String.format(EXCEPTION_JSON, SysApiStatus.SYSTEMERROR, SysApiStatus.getMessage(SysApiStatus.SYSTEMERROR)));
            print.close();
        }
        return null;
    }

    @ExceptionHandler(Throwable.class)
    public String handleError(Exception e, HttpServletRequest request, PrintWriter print) {
        e.printStackTrace();
        if (print != null) {
            print.print(String.format(EXCEPTION_JSON, SysApiStatus.ERROR, SysApiStatus.getMessage(SysApiStatus.ERROR)));
            print.close();
        }
        return null;
    }
    protected ResponseEntity buildResponseEntity(int status, String message, Object data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setStatus(status);
        responseEntity.setMessage(message);
        responseEntity.setData(data);
        return responseEntity;
    }

    /**
     * 构造返回实体类
     *
     * @param code
     * @param data
     * @return
     */
    protected ResponseEntity buildResponseEntity(Integer status, String message) {
        return buildResponseEntity(status, message, "");
    }

    protected ResponseEntity buildResponseEntity(Object data) {
        return buildResponseEntity(SysApiStatus.OK, SysApiStatus.getMessage(SysApiStatus.OK), data);
    }

    public void outJSONArray(HttpServletRequest request,HttpServletResponse response,Object obj)
    {
        JSONObject jsonObject=JSONObject.fromObject(obj);
        response.setContentType("text/json; charset=UTF-8");
        PrintWriter out;
        try
        {
            out = response.getWriter();
            String jsonp=request.getParameter("jsonp");
            if(jsonp!=null){
                out.print(jsonp+"("+jsonObject+")");
            }else{
                out.print(jsonObject);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return;
    }
}
