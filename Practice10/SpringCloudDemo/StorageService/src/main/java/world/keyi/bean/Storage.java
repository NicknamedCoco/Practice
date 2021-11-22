package world.keyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @date 2021年11月15日18:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Integer id;
    private String productId;      //产品id
    private String total;           //总库存
    private String used;            //已用库存
    private String residue;         //剩余库存
}
