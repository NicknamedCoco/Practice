package world.keyi.arsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 万一
 * @date 2021年06月22日10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_case")
public class Case {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;             //主键Id
    private Integer patientsId;     //患者id
    private Integer doctorId;       //医生id
    private String remake;          //病例详情
    private String recipe;          //处方信息
    private Date createTime;        //创建时间
    private Date modifyTime;        //修改时间

    @TableField(exist = false)
    private String patientName;

    @TableField(exist = false)
    private Integer ssex;

    @TableField(exist = false)
    private Date birthday;

    @TableField(exist = false)
    private String depName;

    @TableField(exist = false)
    private String doctorName;
}
