package br.com.lifenance.controller;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class JsonMenssage {

    private final Map<String, Object> map;

    public JsonMenssage(Map<String, Object> map) {
        this.map = map;
    }

    public void returnJson(HttpServletResponse resp) throws IOException {
        try (PrintWriter output = resp.getWriter()) {
            resp.setContentType("br/com/lifenance/application/json");
            resp.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(map));
        }
    }
}
