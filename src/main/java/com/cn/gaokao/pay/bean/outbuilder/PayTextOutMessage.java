package com.cn.gaokao.pay.bean.outbuilder;

import com.cn.gaokao.pay.bean.PayOutMessage;

/**
 * @author egan
 *  <pre>
 *      email egzosn@gmail.com
 *      date 2016-6-1 11:40:30
 *  </pre>
 */
public class PayTextOutMessage extends PayOutMessage {

    public PayTextOutMessage() {
    }

    @Override
    public String toMessage() {
        return getContent();
    }
}
