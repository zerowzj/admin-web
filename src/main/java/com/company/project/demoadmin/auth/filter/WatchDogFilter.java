package com.company.project.demoadmin.auth.filter;

import com.company.project.demoadmin.support.Uris;
import com.company.project.demoadmin.support.context.TrackKey;
import com.google.common.base.Stopwatch;
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
import java.util.concurrent.TimeUnit;

/**
 * 看门狗
 *
 * @author wangzhj
 */
public class WatchDogFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    private static final String REQUEST_ID = "Request-Id";

    private static final String MDC_REQUEST_ID = "request_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (!Uris.isLegal(uri)) {
            //继续执行
            filterChain.doFilter(request, response);
//            LOGGER.info("忽略uri[{}]", uri);
            return;
        }
        //
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            //
            String requestId = request.getHeader(REQUEST_ID);
            if (Strings.isNullOrEmpty(requestId)) {
                requestId = String.valueOf(UUID.randomUUID().hashCode() & 0x7fffffff);
            }
            TrackKey.set(requestId);
            MDC.put(MDC_REQUEST_ID, requestId);
            //继续执行
            filterChain.doFilter(request, response);
        } finally {
            LOGGER.info("uri[{}]cost[{} ms]", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            MDC.clear();
            TrackKey.remove();
        }
    }
}
