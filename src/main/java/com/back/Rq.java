package com.back;

public class Rq {
    private final String cmd;

    public Rq(String cmd){
        this.cmd = cmd;
    }

    public String getActionName() {
        return cmd.split("\\?", 2)[0];

//        if (cmd.equals("수정?id=1")) return "수정";
//        if (cmd.equals("삭제?id=1")) return "삭제";
//  리팩토링 -> 중복제거

    }
}
