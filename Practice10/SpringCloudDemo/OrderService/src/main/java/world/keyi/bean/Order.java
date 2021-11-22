package world.keyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @date 2021年11月15日18:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private String userId;     //用户id
    private String productId;  //产品id
    private String count;       //数量
    private String money;       //金额
    private String status;      //订单状态：0创建中，1已完结
}
