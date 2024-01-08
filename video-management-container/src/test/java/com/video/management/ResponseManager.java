package com.video.management;

import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseManager {

    public static void isStatus201(MvcResult result) {
        isStatus(201, result);
    }

    public static void isStatus400(MvcResult result) {
        isStatus(400, result);
    }

    public static void isStatus404(MvcResult result) {
        isStatus(404, result);
    }

    public static void isStatus409(MvcResult result) {
        isStatus(409, result);
    }

    private static void isStatus(int code, MvcResult result) {
        assertEquals(code, result.getResponse().getStatus());
    }
}
