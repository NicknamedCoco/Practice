package world.keyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 万一
 * @date 2021年11月15日18:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private String userId;     //用户id
    private String total;       //总额度
    private String used;        //已用额度
    private String residue;     //剩余可用额度
}
