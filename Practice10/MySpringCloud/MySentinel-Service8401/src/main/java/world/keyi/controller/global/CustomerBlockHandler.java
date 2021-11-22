package world.keyi.controller.global;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author 万一
 * @date 2021年11月09日14:45
 */
public class CustomerBlockHandler {
    public static String handlerException(int id,BlockException exception){
        return "全局降级方法"+id;
    }
}
