package com.zj.api.common.message.process;

import java.io.Serializable;

/**
 * Created by js on 2017/1/18.
 */
public interface BaseMsgProcessor {

    void process(Serializable serializable);

}
