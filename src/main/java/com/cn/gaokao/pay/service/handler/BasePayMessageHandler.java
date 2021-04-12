package com.cn.gaokao.pay.service.handler;

import com.cn.gaokao.pay.api.PayMessageHandler;
import com.cn.gaokao.pay.api.PayService;
import com.cn.gaokao.pay.bean.PayMessage;

/**
 *
 * Created by ZaoSheng on 2016/6/1.
 */
public abstract class BasePayMessageHandler<M extends PayMessage, S extends PayService> implements PayMessageHandler<M, S> {
    //支付账户id
    private Integer payId;

    public BasePayMessageHandler(Integer payId) {
        this.payId = payId;
    }

    public Integer getPayId() {
        return payId;
    }
}
