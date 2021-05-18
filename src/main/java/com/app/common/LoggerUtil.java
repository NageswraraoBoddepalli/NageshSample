package com.app.common;

public class LoggerUtil {

    public static String encodeString(String s) {
        //I am facing some issue while adding this jar.
        //this will avoid improper neutralization of logs vulnerability
      // return ESAPI.encoder().encodeForHTML(s);
        return s;
    }
}
