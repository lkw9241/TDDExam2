package com.back;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final String cmd;
    private final Map<String, String> params;

    public Rq(String cmd){
        this.cmd = cmd;

        String queryString = cmd.split("\\?", 2)[1];

        String[] queryStringBits = queryString.split("&");

        params = new HashMap<>();

        for( String queryStr : queryStringBits) {
            String[] paramStrBits = queryStr.split("=", 2);

            String paramName = paramStrBits[0];
            String paramValue = paramStrBits[1];

            params.put(paramName, paramValue);
        }

    }

    public String getActionName() {
        return cmd.split("\\?", 2)[0];
    }

    public String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);

    }
}

//        if (cmd.equals("등록?고향=남원")&& name.equals("고향")) return "남원";
//        if (cmd.equals("등록?이름=홍길동")&& name.equals("이름")) return "홍길동";


//        if (cmd.equals("수정?id=1")) return "수정";
//        if (cmd.equals("삭제?id=1")) return "삭제";
//  리팩토링 -> 중복제거





