package com.yzl.framework.beam.util;

import com.yzl.framework.beam.exception.BeamAbstractException;
import com.yzl.framework.beam.exception.BeamBizException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionUtil {

    public static final StackTraceElement[] REMOTE_MOCK_STACK = new StackTraceElement[]{new StackTraceElement("remoteClass",
            "remoteMethod", "remoteFile", 1)};

    /**
     * 判定是否是业务方的逻辑抛出的异常
     * <p>
     * true: 来自业务方的异常
     * false: 来自框架本身的异常
     *
     * @param t
     * @return
     */
    public static boolean isBizException(Throwable t) {
        return t instanceof BeamBizException;
    }


    public static boolean isBeamException(Throwable t) {
        return t instanceof BeamAbstractException;
    }


    /**
     * 覆盖给定exception的stack信息，server端产生业务异常时调用此类屏蔽掉server端的异常栈。
     *
     * @param e
     */
    public static void setMockStackTrace(Throwable e) {
        if (e != null) {
            try {
                e.setStackTrace(REMOTE_MOCK_STACK);
            } catch (Exception e1) {
                log.warn("replace remote exception stack fail!" + e1.getMessage());
            }
        }
    }
}
