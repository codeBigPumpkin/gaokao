package com.ceev.wcee.pay.service.handler;

import com.ceev.wcee.pay.api.PayService;
import com.ceev.wcee.pay.bean.PayOutMessage;
import com.ceev.wcee.pay.exception.PayErrorException;
import com.ceev.wcee.pay.wx.bean.WxPayMessage;

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
