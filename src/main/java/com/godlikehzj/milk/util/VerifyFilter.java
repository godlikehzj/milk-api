package com.godlikehzj.milk.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by godlikehzj on 15/9/10.
 */
public class VerifyFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, String> paramMap = new HashMap<String, String>();
        Map<String, String> map = req.getParameterMap();
        for (Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator(); iter.hasNext();) {
            Map.Entry element = iter.next();
            Object key = element.getKey();
            Object strObj = element.getValue();
            String[] value = (String[]) strObj;
            paramMap.put(key.toString(), value[0]);
        }
        ResponseEntity responseEntity =checkParam(paramMap);
        if(responseEntity==null){
            chain.doFilter(request, response);
        }else{
            JSONObject jsonObject=JSONObject.fromObject(responseEntity);
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
        }
    }

    public ResponseEntity checkParam(Map<String, String> paramMap) {
		/*
		if (StringUtils.isBlank(paramMap.get("poid"))) {
			return new ResponseEntity(SysApiStatus.ERRORPOID, SysApiStatus.getMessage(SysApiStatus.ERRORPOID), "");// 产品号无效
		}
		if (StringUtils.isBlank(paramMap.get("plat"))) {
			return new ResponseEntity(SysApiStatus.ERRORPLAT, SysApiStatus.getMessage(SysApiStatus.ERRORPLAT), "");// 平台号无效
		}
		if (StringUtils.isBlank(paramMap.get("sver"))) {
			return new ResponseEntity(SysApiStatus.ERRORSVER, SysApiStatus.getMessage(SysApiStatus.ERRORSVER), "");// 版本号无效
		}

		if (StringUtils.isBlank(paramMap.get("channelID"))) {
			return new ResponseEntity(SysApiStatus.ERRORCHANNEL, SysApiStatus.getMessage(SysApiStatus.ERRORCHANNEL), "");// channel无效
		}

        if (StringUtils.isBlank(paramMap.get("ts"))) {
            return new ResponseEntity(SysApiStatus.ERRORTS, SysApiStatus.getMessage(SysApiStatus.ERRORTS), "");// ts无效
        }

		if (StringUtils.isBlank(paramMap.get("deviceType"))) {
			return new ResponseEntity(SysApiStatus.ERRORDEVICETYPE, SysApiStatus.getMessage(SysApiStatus.ERRORDEVICETYPE), "");// deviceType无效
		}

		if (StringUtils.isBlank(paramMap.get("intranet"))) {
			return new ResponseEntity(SysApiStatus.INTRANETERROR, SysApiStatus.getMessage(SysApiStatus.INTRANETERROR), "");// intranet无效
		}

		//校验是否debug模式
		if(!StringUtils.isBlank(paramMap.get("debug"))){
			return null;
		}


		if(Intranet.inner.equals(paramMap.get("intranet"))){
			return null;
		}

		//以下校验只用于内网访问

		if (StringUtils.isBlank(paramMap.get("verify"))) {
			return new ResponseEntity(SysApiStatus.ERRORVERIFY, SysApiStatus.getMessage(SysApiStatus.ERRORVERIFY), "");// verify无效
		}
		if (StringUtils.isBlank(paramMap.get("model"))) {
			return new ResponseEntity(SysApiStatus.ERRORMODEL, SysApiStatus.getMessage(SysApiStatus.ERRORMODEL), "");// model无效
		}
		if (StringUtils.isBlank(paramMap.get("macId"))) {
			return new ResponseEntity(SysApiStatus.ERRORMACID, SysApiStatus.getMessage(SysApiStatus.ERRORMACID), "");// mac地址无效
		}

		String verify = paramMap.get("verify");
		paramMap.remove("verify");
		paramMap.remove("jsonp");

		if (!verify.equals(SignatureUtil.signature(paramMap, SignatureUtil.SECURITY_KEY))) {// 校验verify的有效性
			return new ResponseEntity(SysApiStatus.ERRORVERIFY, SysApiStatus.getMessage(SysApiStatus.ERRORVERIFY), "");// verify无效
		}
		*/
        return null;
    }

    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
