# MyMVPStudy
andorid MVP 学习

>下图是个人理解的MVP及接口之间的关系处理图

![](https://github.com/lisheny/MyMVPStudy/blob/master/MyMVPStudy/app/src/main/res/mipmap-xxxhdpi/xxx00.png?raw=true)

##### 1--------------------------> LoginInteractorImpl 实现 LoginInteractor 里面的 login（）

1.1 LoginInteractorImpl 处理相应的登录逻辑，有结果后调用从 Login() 中传入的 OnLoginFinishedListerner 接口，将相应的结果回调到 LoginPresenterImpl 中。


##### 2--------------------------> LoginPresenterImpl 实现 LoginInteractor 里面的    OnLoginFinishedListerner接口

2.1 LoginPresenterImpl 根据 OnLoginFinishedListerner 接口中回调的方法调用 LoginView 接口中的方法回调到 LoginAcitivity 中处理。

##### 3--------------------------> LoginPresenterImpl 从 LoginActivity 中取得实例

     mLoginPresenter = new LoginPresenterImpl(this);
3.1 LoginInteractor、Loginview 从 LoginPresenterImpl 中获取实例：
  
    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

##### 4--------------------------> LoginActivity 实现Loginview 接口

4.1 LoginActivity 实现Logiview 接口中定义的方法，作相应的UI变化

##### 5--------------------------> LoginPresenterImpl 实现 LoginPresenter 接口

###### 个人见解:如果业务逻辑不是很复杂，完全去掉M（model）这一块，直接在 P 中写业务逻辑,甚至直接在Activity中写好了，灵活运用，不能为了框架而框架...（话说，小项目也没什么必要用MVP了 0.0）

更多相关资料学习[戳这里](http://zjutkz.net/2016/04/13/%E9%80%89%E6%8B%A9%E6%81%90%E6%83%A7%E7%97%87%E7%9A%84%E7%A6%8F%E9%9F%B3%EF%BC%81%E6%95%99%E4%BD%A0%E8%AE%A4%E6%B8%85MVC%EF%BC%8CMVP%E5%92%8CMVVM/)

MVPPlugin插件介绍，直接[戳这里](http://yugai.github.io/2017/02/27/AndroidStudio-MVPPlugin/)
 


