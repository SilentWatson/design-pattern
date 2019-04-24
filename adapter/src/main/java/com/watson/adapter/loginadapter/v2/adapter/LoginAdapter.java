package com.watson.adapter.loginadapter.v2.adapter;

import com.watson.adapter.loginadapter.ResultMsg;

public interface LoginAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object a);
}
