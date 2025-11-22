package com.ly.weblogmodulecommon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author: 骆洋
 * @date: 2025/11/20 19:32
 * @description: Json 工具类用于将传入的对象打印成 JSON 字符串
 **/
public class JsonUtil {
   private static ObjectMapper INSTANCE =   new ObjectMapper();
   public static String toJsonString(Object obj){
       try {
           return INSTANCE.writeValueAsString(obj);
       } catch (JsonProcessingException e) {
           return obj.toString();
       }
   }
}
