package com.jetpack.lib.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        /**
         * 微信公众号 属于 发布者主题角色 被观察者 时间的发布者
         * 订阅用户 属于 订阅者 观察者角色  时间的接收者
         */

        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attch(new WeiXinUser("张三"));
        subject.attch(new WeiXinUser("李四"));
        subject.attch(new WeiXinUser("王五"));
        subject.attch(new WeiXinUser("赵六"));

        subject.notifyObserver("有新消息了");

    }
}
