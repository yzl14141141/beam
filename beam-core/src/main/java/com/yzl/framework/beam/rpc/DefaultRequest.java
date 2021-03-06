package com.yzl.framework.beam.rpc;

import com.yzl.framework.beam.util.BeamFrameworkUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class DefaultRequest implements Serializable, Request {

    private long requestId;
    private String interfaceName;
    private String methodName;
    private String[] parameterTypes;
    private Object[] arguments;
    private Class<?> returnType;
    private Map<String, String> attachments = new HashMap<>();
    private int retries = 0;

    @Override
    public void setAttachment(String key, String value) {
        this.attachments.put(key, value);
    }

    public String toString() {
        return BeamFrameworkUtil.toString(this);
    }

}
