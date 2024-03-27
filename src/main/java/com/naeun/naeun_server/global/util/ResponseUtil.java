package com.naeun.naeun_server.global.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naeun.naeun_server.global.common.ResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class ResponseUtil {
    public static void setResponse(HttpServletResponse response, int status, String message) throws IOException {
        ResponseDto dto = ResponseDto.of(status, message);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setStatus(status);
        response.getWriter().write(new ObjectMapper().writeValueAsString(dto));
    }
}
