package com.snippet.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.core.ReflectUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PojoUtils {

    public static <R, T> R copyBean(T source, Class<R> clazz) {
        R target = (R) ReflectUtils.newInstance(clazz);
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <R, T> List<R> copyBean(List<T> sources, Class<R> clazz) {
        return sources.stream().map(source -> copyBean(source, clazz)).collect(Collectors.toList());
    }

    public static <R> R readValue(String source, Class<R> clazz) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(source, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String writeValueAsString(T t) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}