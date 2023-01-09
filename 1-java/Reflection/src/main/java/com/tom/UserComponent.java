package com.tom;

import com.jerry.Controller;
import com.jerry.RequestMapping;
import com.jerry.RequestMethod;

/**
 * author : Tom
 */
@Controller()
@RequestMapping(url="/users")
public class UserComponent {

    @RequestMapping(method = RequestMethod.POST,url = "/register")
    public void doRegister(){
        System.out.println("doRegister");
    }

    @RequestMapping(method = RequestMethod.POST,url = "/login")
    public void doLogin() {
        System.out.println("doLogin");
    }

}
