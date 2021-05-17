package com.example.demo.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化对象:配置区域信息解析器,点击切换中英文效果,参数方式为 语言_国家代码方式th:href="@{/xxx.html(lang='zh_CN')}",
 * 默认属性文件messages.properties必须有
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getParameter("lang");
        Locale locale = Locale.getDefault();//默认语言
        if (!StringUtils.isEmpty(lang)) {
            String[] split = lang.split("_");
            // split[0]语言,[1]国家
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
