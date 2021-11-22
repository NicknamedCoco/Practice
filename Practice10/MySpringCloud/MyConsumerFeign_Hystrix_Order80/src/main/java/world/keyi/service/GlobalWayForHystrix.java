package world.keyi.service;

import org.springframework.stereotype.Component;

/**
 * @author 万一
 * @date 2021年10月26日10:29
 */
@Component
public class GlobalWayForHystrix implements MyFeignWithPayment {
    @Override
    public String getPaymentInfo_OKTest(String id) {
        return "被熔断器阻拦到，请求接口失败";
    }

    @Override

    public String getPaymentInfo_NotOKTest(String id) {
        return "被熔断器阻拦到，请求接口失败";
    }
}
