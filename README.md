# EventBusTest
EventBus的demo,简单入门
#
![image](https://github.com/itlhy/EventBusTest/blob/master/app/EventBus%E7%9A%84demo.gif)

简单入门:
好处: 发消息和接收消息完全解耦
1.	新建一个项目,在build.gradle添加依赖  compile 'org.greenrobot:eventbus:3.0.0' 然后同步
2.	需要两个Activity  MainActivity和SecondActivity. 在MainActivity接收消息,在SecondActivity发送消息

3.	新建一个类,用来传递消息
```
public class FirstEvent {
    private String mMsg;

    public FirstEvent(String msg) {
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}
```

4.	在MainActivity的onCreate里注册EventBus:
```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //注册EventBus
    EventBus.getDefault().register(this);
}
```
5.	然后在MainActivity里重写一个EventBus的方法(一共有四个,根据自己需要即可,注解 @Subscribe):
```
/**
 * 订阅事件FirstEvent
 * @param event 注意参数是用来传递消息的类
 */
@Subscribe
public void onEventMainThread(FirstEvent event) {
    String msg = "第一个界面收到了消息：" + event.getMsg();
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
}
```
6.	在SecondActivity里发送消息即可,例如:
```
EventBus.getDefault().post(new FirstEvent("我是第二个界面发来的消息"));
```

然后MainActivity就会弹出Toast消息
