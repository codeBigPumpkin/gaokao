package com.ceev.wcee.pay.bean.outbuilder;

import com.ceev.wcee.pay.bean.PayOutMessage;

/**
 * source chanjarster/weixin-java-tools
 *
 * @author  egan
 * <pre>
 *     email egzosn@gmail.com
 *     date 2016-6-1 11:40:30
 *  </pre>
 */
public abstract class BaseBuilder<BuilderType, ValueType> {


    public abstract ValueType build();

    public void setCommon(PayOutMessage m) {

    }

}