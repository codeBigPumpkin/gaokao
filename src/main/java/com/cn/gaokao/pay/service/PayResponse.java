package com.cn.gaokao.pay.service;

import javax.annotation.Resource;

import com.cn.gaokao.pay.entity.ApyAccount;
import com.cn.gaokao.pay.entity.PayType;
import com.cn.gaokao.pay.service.handler.WxPayMessageHandler;
import com.cn.gaokao.pay.service.handler.AliPayMessageHandler;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.cn.gaokao.pay.api.PayConfigStorage;
import com.cn.gaokao.pay.api.PayMessageHandler;
import com.cn.gaokao.pay.api.PayMessageRouter;
import com.cn.gaokao.pay.api.PayService;
import com.cn.gaokao.pay.http.HttpConfigStorage;
import com.cn.gaokao.pay.service.interceptor.AliPayMessageInterceptor;

/**
 * 支付响应对象
 *
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/18 0:34
 */
public class PayResponse {

    @Resource
    private AutowireCapableBeanFactory spring;

    private PayConfigStorage storage;

    private PayService service;

    private PayMessageRouter router;

    public PayResponse() {

    }

    /**
     * 初始化支付配置
     *
     * @param apyAccount 账户信息
     * @see ApyAccount 对应表结构详情--》 /pay-java-demo/resources/apy_account.sql
     */
    public void init(ApyAccount apyAccount) {
        //根据不同的账户类型 初始化支付配置
        this.service = apyAccount.getPayType().getPayService(apyAccount);
        this.storage = service.getPayConfigStorage();
        //这里设置http请求配置
//        service.setRequestTemplateConfigStorage(getHttpConfigStorage());
        buildRouter(apyAccount.getPayId());
    }

    /**
     * 获取http配置，如果配置为null则为默认配置，无代理,无证书的请求方式。
     * 此处非必需
     *
     * @param apyAccount 账户信息
     * @return 请求配置
     */
    public HttpConfigStorage getHttpConfigStorage(ApyAccount apyAccount) {
        HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
        /* 网路代理配置 根据需求进行设置*/
//        //http代理地址
//        httpConfigStorage.setHttpProxyHost("192.168.1.69");
//        //代理端口
//        httpConfigStorage.setHttpProxyPort(3308);
//        //代理用户名
//        httpConfigStorage.setHttpProxyUsername("user");
//        //代理密码
//        httpConfigStorage.setHttpProxyPassword("password");
        //设置ssl证书路径 https证书设置 方式二
        httpConfigStorage.setKeystore(apyAccount.getKeystorePath());
        //设置ssl证书对应的密码
        httpConfigStorage.setStorePassword(apyAccount.getStorePassword());
        return httpConfigStorage;
    }


    /**
     * 配置路由
     *
     * @param payId 指定账户id，用户多微信支付多支付宝支付
     */
    private void buildRouter(Integer payId) {
        router = new PayMessageRouter(this.service);
        router
                .rule()
                //消息类型
                //支付账户事件类型
                .payType(PayType.aliPay.name())
                //拦截器
                .interceptor(new AliPayMessageInterceptor())
                //处理器
                .handler(spring.getBean(AliPayMessageHandler.class))
                .end()
                .rule()
                .payType(PayType.wxPay.name())
                .handler(autowire(new WxPayMessageHandler(payId)))
                .end()
        ;
    }


    private PayMessageHandler autowire(PayMessageHandler handler) {
        spring.autowireBean(handler);
        return handler;
    }

    public PayConfigStorage getStorage() {
        return storage;
    }

    public PayService getService() {
        return service;
    }

    public PayMessageRouter getRouter() {
        return router;
    }
}
