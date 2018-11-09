package com.huju.crud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的错误参数
 * Created by huju on 2018/10/21.
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    // 返回值就是頁面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("boss", "huju");

        // 从request域中拿到我们自己在全局异常处理器里加上的数据
        @SuppressWarnings("unchecked")
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        errorAttributes.put("ext", ext);
        return errorAttributes;
    }
}
