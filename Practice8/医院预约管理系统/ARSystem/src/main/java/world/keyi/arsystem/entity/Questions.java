package world.keyi.arsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 万一
 * @date 2021年06月22日10:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_questions")
public class Questions implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;             //主键Id
    private String title;           //问题/回复
    private Integer parentId;       //问题id
    private Integer doctorId;       //医生Id
    private Integer patientId;     //问题所属患者id

    @TableField
    private Date createTime;        //创建时间
    @TableField
    private Date modifyTime;        //修改时间


    /**
     * 患者姓名
     */
    @TableField(exist = false)
    private String patientName;

    /**
     * 患者性别
     */
    @TableField(exist = false)
    private Integer ssex;

    /**
     * 患者生日
     */
    @TableField(exist = false)
    private Date birthday;

    /**
     *  回复内容
     */
    @TableField(exist = false)
    private String reply;

    /**
     * 回复时间，HH表示24小时进制,hh表示12小时进制
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(exist = false)
    private Date replyTime;

    /**
     * 回复医生姓名
     */
    @TableField(exist = false)
    private String replyName;

    @TableField(exist = false)
    private List<Questions> questions;

}
