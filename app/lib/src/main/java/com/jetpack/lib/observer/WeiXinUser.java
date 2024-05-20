package com.jetpack.lib.observer;


import com.jetpack.lib.observer.Observer;

//具体的订阅者 (观察者)
public class WeiXinUser implements Observer {
    String name;

    public WeiXinUser(String s) {
        name = s;
    }

    @Override
    public void updata(String data) {
        System.out.println(name + "----" + data);
    }
}
