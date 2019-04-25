package com.watson.decorator.passport.upgrade;


import com.watson.decorator.passport.old.ISigninService;
import com.watson.decorator.passport.old.Member;
import com.watson.decorator.passport.old.ResultMsg;

public class SignForThirdService implements ISignForThirdService {
    private ISigninService signinService;
    public SignForThirdService(ISigninService signinService) {
        this.signinService = signinService;
    }
    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
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

    @Override
    public ResultMsg regist(String username, String password) {
        return this.signinService.regist(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return this.signinService.login(username, password);
    }
}
