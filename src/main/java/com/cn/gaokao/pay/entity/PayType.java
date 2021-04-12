package com.cn.gaokao.pay.entity;

import com.cn.gaokao.pay.service.handler.WxPayMessageHandler;
import com.cn.gaokao.pay.ali.api.AliPayConfigStorage;
import com.cn.gaokao.pay.ali.api.AliPayService;
import com.cn.gaokao.pay.ali.bean.AliTransactionType;
import com.cn.gaokao.pay.api.PayService;
import com.cn.gaokao.pay.bean.BasePayType;
import com.cn.gaokao.pay.bean.TransactionType;
import com.cn.gaokao.pay.http.HttpConfigStorage;
import com.cn.gaokao.pay.wx.api.WxPayConfigStorage;
import com.cn.gaokao.pay.wx.api.WxPayService;
import com.cn.gaokao.pay.wx.bean.WxTransactionType;


/**
 * 支付类型
 *
 * @author egan
 * email egzosn@gmail.com
 * date 2016/11/20 0:30
 */
public enum PayType implements BasePayType {


    aliPay {
        /**
         *  @see AliPayService
         * @param apyAccount
         * @return
         */
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            AliPayConfigStorage configStorage = new AliPayConfigStorage();
            //配置的附加参数的使用
            configStorage.setAttach(apyAccount.getPayId());
            configStorage.setPid(apyAccount.getPartner());
            configStorage.setAppId(apyAccount.getAppId());
            configStorage.setKeyPublic(apyAccount.getPublicKey());
            configStorage.setKeyPrivate(apyAccount.getPrivateKey());
            configStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            configStorage.setReturnUrl(apyAccount.getReturnUrl());
            configStorage.setSignType(apyAccount.getSignType());
            configStorage.setSeller(apyAccount.getSeller());
            configStorage.setPayType(apyAccount.getPayType().toString());
            configStorage.setInputCharset(apyAccount.getInputCharset());
            configStorage.setTest(apyAccount.isTest());
            //请求连接池配置
            HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
            //最大连接数
            httpConfigStorage.setMaxTotal(20);
            //默认的每个路由的最大连接数
            httpConfigStorage.setDefaultMaxPerRoute(10);
            return new AliPayService(configStorage, httpConfigStorage);
        }

        @Override
        public TransactionType getTransactionType(String transactionType) {
            // com.egzosn.pay.ali.before.bean.AliTransactionType 17年更新的版本,旧版本请自行切换

            // AliTransactionType 17年更新的版本,旧版本请自行切换
            return AliTransactionType.valueOf(transactionType);
        }


    }, wxPay {
        @Override
        public PayService getPayService(ApyAccount apyAccount) {
            WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
            wxPayConfigStorage.setMchId(apyAccount.getPartner());
            wxPayConfigStorage.setAppId(apyAccount.getAppId());
            //转账公钥，转账时必填
            wxPayConfigStorage.setKeyPublic(apyAccount.getPublicKey());
            wxPayConfigStorage.setSecretKey(apyAccount.getPrivateKey());
            wxPayConfigStorage.setNotifyUrl(apyAccount.getNotifyUrl());
            wxPayConfigStorage.setReturnUrl(apyAccount.getReturnUrl());
            wxPayConfigStorage.setSignType(apyAccount.getSignType());
            wxPayConfigStorage.setPayType(apyAccount.getPayType().toString());
            wxPayConfigStorage.setInputCharset(apyAccount.getInputCharset());
            wxPayConfigStorage.setTest(apyAccount.isTest());

            //https证书设置 方式一
        /*    HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
             //TODO 这里也支持输入流的入参。
//          httpConfigStorage.setKeystore(PayType.class.getResourceAsStream("/证书文件"));
            httpConfigStorage.setKeystore("证书信息串");
            httpConfigStorage.setStorePassword("证书密码");
            //设置ssl证书对应的存储方式，这里默认为文件地址
            httpConfigStorage.setCertStoreType(CertStoreType.PATH);
            return  new WxPayService(wxPayConfigStorage, httpConfigStorage);*/
            WxPayService wxPayService = new WxPayService(wxPayConfigStorage);
            wxPayService.setPayMessageHandler(new WxPayMessageHandler(1));
            return wxPayService;
        }

        /**
         * 根据支付类型获取交易类型
         * @param transactionType 类型值
         * @see WxTransactionType
         * @return
         */
        @Override
        public TransactionType getTransactionType(String transactionType) {

            return WxTransactionType.valueOf(transactionType);
        }
    }
    ;

    public abstract PayService getPayService(ApyAccount apyAccount);


}
