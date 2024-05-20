package com.jetpack.lib.observer;

import com.jetpack.lib.observer.Observer;
import com.jetpack.lib.observer.Subject;

import java.util.ArrayList;
import java.util.List;
//发布者(被观察者,主题)的具体实现   事件的产出方 . 类似与公众号 博主
//Observables被观察者
public class SubscriptionSubject implements Subject {
    //添加所有的观察者 这样当事件发生改变时,才能通知所有的观察者
    List<Observer> list = new ArrayList<>();

    //添加订阅者(添加观察者)
    @Override
    public void attch(Observer observer) {
        list.add(observer);
    }

    //删除订阅者(删除观察者)
    @Override
    public void deAttch(Observer observer) {
        list.remove(observer);
    }

    //更新内容
    @Override
    public void notifyObserver(String data) {
        for (Observer observer : list) {
            observer.updata(data);
        }
    }
}
