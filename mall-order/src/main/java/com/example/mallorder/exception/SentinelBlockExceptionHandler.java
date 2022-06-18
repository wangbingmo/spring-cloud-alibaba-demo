package com.example.mallorder.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.api.ResultCode;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现sentinel自定义异常返回
 * 也可以通过添加Config类实现-> <a href="https://github.com/sentinel-group/sentinel-guides/blob/8f2ec31407e8479a4a394c67846c9723269e04f8/sentinel-guide-spring-cloud/web-api-demo/src/main/java/com/alibaba/csp/sentinel/demo/config/SentinelWebConfig.java">示例</a>
 * 参考blog: <a href="https://genjiejie.blog.csdn.net/article/details/109458856">地址</a>
 */
@Component
public class SentinelBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        CommonResult<Object> data = null;
        if (e instanceof FlowException) {
            data = CommonResult.failed(ResultCode.SENTINEL_FLOW, ResultCode.SENTINEL_FLOW.getMessage());
        } else if (e instanceof DegradeException) {
            data = CommonResult.failed(ResultCode.SENTINEL_DEGRADE, ResultCode.SENTINEL_DEGRADE.getMessage());
        } else if (e instanceof AuthorityException) {
            data = CommonResult.failed(ResultCode.SENTINEL_AUTHORITY, ResultCode.SENTINEL_AUTHORITY.getMessage());
        } else if (e instanceof ParamFlowException) {
            data = CommonResult.failed(ResultCode.SENTINEL_PARAM_FLOW, ResultCode.SENTINEL_SYSTEM_BLOCK.getMessage());
        } else if (e instanceof SystemBlockException) {
            data = CommonResult.failed(ResultCode.SENTINEL_SYSTEM_BLOCK, ResultCode.SENTINEL_SYSTEM_BLOCK.getMessage());
        }

        httpServletResponse.getWriter().write(JSON.toJSONString(data));
    }
}
