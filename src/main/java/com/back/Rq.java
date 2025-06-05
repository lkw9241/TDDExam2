package com.back;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String cmd;
    private final Map<String, String> params;

    public Rq(String cmd){
        this.cmd = cmd;

        String queryString = cmd.split("\\?", 2)[1];
        params = Arrays
                .stream(queryString.split("&"))
                .map(e -> e.split("=", 2))
                .collect(Collectors. toMap( e-> e[0], e -> e[1]));

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





