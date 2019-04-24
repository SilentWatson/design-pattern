package com.watson.adapter.loginadapter.v2.adapter;

import com.watson.adapter.loginadapter.ResultMsg;

public class LoginForQQAdapter implements LoginAdapter{
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginAdapter;
    }

    @Override
    public ResultMsg login(String id, Object a) {
        return null;
    }
}
