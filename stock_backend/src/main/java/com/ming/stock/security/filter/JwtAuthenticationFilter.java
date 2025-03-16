package com.ming.stock.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ming.stock.security.util.JwtTokenUtil;
import com.ming.stock.vo.resp.R;
import com.ming.stock.vo.resp.ResponseCode;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @Author: Ming
 * @Description 定义授权过滤器 本质就是一切的请求 获取请求头的token 然后进行校验
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    /**
     * 执行JWT令牌认证过滤逻辑
     *
     * @param request HTTP请求对象，用于获取请求头、参数等信息
     * @param response HTTP响应对象，用于返回错误响应信息
     * @param filterChain 过滤器链对象，用于继续执行后续过滤器或目标资源
     * @throws ServletException 当请求处理过程中发生servlet相关异常时抛出
     * @throws IOException 当输入输出异常发生时抛出
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 从请求头中获取JWT令牌字符串（未认证请求可能不存在该令牌）
        String jwtToken = request.getHeader(JwtTokenUtil.TOKEN_HEADER);

        // 无令牌请求直接放行，由后续过滤器处理认证流程
        if (StringUtils.isBlank(jwtToken)){
            filterChain.doFilter(request,response);
            return;
        }

        // 校验JWT令牌合法性
        Claims claims = JwtTokenUtil.checkJWT(jwtToken);

        // 处理无效令牌场景：返回401错误并终止过滤器链
        if (claims == null){
            R<Object> error = R.error(ResponseCode.INVALID_TOKEN);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(error));
            return;
        }

        // 解析有效令牌中的用户身份信息
        String username = JwtTokenUtil.getUsername(jwtToken);
        String roles = JwtTokenUtil.getUserRole(jwtToken);

        // 转换角色字符串为权限对象集合（处理格式如[ROLE_ADMIN]的字符串）
        String comStr = StringUtils.strip(roles, "[]");
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(comStr);

        // 构建已认证的凭证对象（密码字段置空）
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, null, authorities);

        // 将认证信息存入安全上下文，供后续过滤器使用
        SecurityContextHolder.getContext().setAuthentication(token);

        // 继续执行后续过滤器链处理
        filterChain.doFilter(request,response);
    }

}
