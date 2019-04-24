package com.watson.adapter.loginadapter.v2;

import com.watson.adapter.loginadapter.ResultMsg;
import com.watson.adapter.loginadapter.v1.service.SiginService;
import com.watson.adapter.loginadapter.v2.adapter.LoginAdapter;
import com.watson.adapter.loginadapter.v2.adapter.LoginForQQAdapter;

public class PassportForThirdAdapter extends SiginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }
    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz){
        try{
            LoginAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(key, adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
