package com.watson.decorator.passport;

import com.watson.decorator.passport.old.ResultMsg;
import com.watson.decorator.passport.old.SigninService;
import com.watson.decorator.passport.upgrade.ISignForThirdService;
import com.watson.decorator.passport.upgrade.SignForQQDecorator;
import com.watson.decorator.passport.upgrade.SignForThirdService;

public class DecoratorTest {
    public static void main(String[] args) {
        ISignForThirdService signForThirdService = new SignForQQDecorator(new SignForThirdService(new SigninService()));
        ResultMsg resultMsg = signForThirdService.loginForQQ("iiii");
        System.out.println(resultMsg.toString());
    }
}
