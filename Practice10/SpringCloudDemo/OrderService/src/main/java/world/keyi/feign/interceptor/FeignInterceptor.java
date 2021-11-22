package world.keyi.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.common.util.StringUtils;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 万一
 * @DATE 2021年11月18日10:11
 */
//@Configuration
@Slf4j
public class FeignInterceptor implements RequestInterceptor {



    @Override
    public void apply(RequestTemplate template) {
        //解决seata的xid未传递
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            log.info("feign传递分布式事务xid：{}", xid);
            template.header(RootContext.KEY_XID, xid);
        }
    }
}
