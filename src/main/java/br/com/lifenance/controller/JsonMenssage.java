package br.com.lifenance.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JsonMenssage {

    private final Map<String, Object> map = new HashMap<>();
    private final HttpServletResponse resp;

    public JsonMenssage(HttpServletResponse resp) {
        this.resp = resp;
    }

    public void sendError(String message) throws IOException {
        map.put("error", true);
        map.put("text", message);
        returnJson();
    }

    public void sendError(boolean status) throws IOException {
        map.put("error", status);
        returnJson();
    }

    public void sendInfo(String message) throws IOException {
        map.put("error", false);
        map.put("text", message);
        returnJson();
    }

    private void returnJson() throws IOException {
        try (PrintWriter output = resp.getWriter()) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(map));
        }
    }
}
