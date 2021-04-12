package com.cn.gaokao.pay.service.handler;

import com.cn.gaokao.pay.api.PayService;
import com.cn.gaokao.pay.bean.PayOutMessage;
import com.cn.gaokao.pay.exception.PayErrorException;
import com.cn.gaokao.pay.wx.bean.WxPayMessage;

import java.util.Map;

/**
 * 微信支付回调处理器
 * Created by ZaoSheng on 2016/6/1.
 */
public class WxPayMessageHandler extends BasePayMessageHandler<WxPayMessage, PayService> {




    public WxPayMessageHandler(Integer payId) {
        super(payId);
    }

    @Override
    public PayOutMessage handle(WxPayMessage payMessage, Map<String, Object> context, PayService payService) throws PayErrorException {
        //交易状态
        if ("SUCCESS".equals(payMessage.getPayMessage().get("result_code"))){
            /////这里进行成功的处理

            return  payService.getPayOutMessage("SUCCESS", "OK");
        }

        return  payService.getPayOutMessage("FAIL", "失败");
    }
}
