package com.company.project.demoweb.auth.filter;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 看门狗
 *
 * @author wangzhj
 */
public class WatchDogFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    private static final String REQUEST_ID = "Request-Id";

    private static final String REQUEST_ID_ = "request_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            //
            String requestId = request.getHeader(REQUEST_ID);
            if (Strings.isNullOrEmpty(requestId)) {
                requestId = String.valueOf(UUID.randomUUID().hashCode() & 0x7fffffff);
            }
            //
            MDC.put(REQUEST_ID_, requestId);
            LOGGER.info("SSSSSSSSSSS");
            //
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
