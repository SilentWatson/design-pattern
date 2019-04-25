package com.watson.decorator.passport.upgrade;

import com.watson.decorator.passport.old.ISigninService;
import com.watson.decorator.passport.old.Member;
import com.watson.decorator.passport.old.ResultMsg;

public class SignForQQDecorator extends SignForThirdService{
    public SignForQQDecorator(ISigninService signinService) {
        super(signinService);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return new ResultMsg(200,"QQ登陆成功",new Member());
    }
}
