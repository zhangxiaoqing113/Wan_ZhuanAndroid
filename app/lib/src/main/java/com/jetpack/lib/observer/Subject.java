package com.jetpack.lib.observer;

import com.jetpack.lib.observer.Observer;

//发布者(被观察者,主题)  事件的产出方 . 类似与公众号 博主
interface Subject {
    public void attch(Observer observer);

    public void deAttch(Observer observer);

    public void notifyObserver(String data);

}
