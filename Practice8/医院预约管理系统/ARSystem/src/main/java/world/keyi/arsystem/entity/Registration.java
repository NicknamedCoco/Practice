package world.keyi.arsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import world.keyi.arsystem.utils.AgeFromBirthdayUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author 万一
 * @date 2021年06月22日10:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_registration")
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;             //主键id
    private String number;          //唯一编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;              //预约时间，默认为当前时间
    private Date createTime;        //挂号时间
    private Integer doctorId;       //挂号医生
    private Integer patientsId;     //挂号患者Id
    private Integer status;         //0:未处理，1已处理
    private String evaluate;        //满意，一般，不满意
    private Integer accept;         //状态，1为采纳，2为不采纳
    private Boolean isCases;        //是否需要病历本
    private BigDecimal amountPayable;   //金额
    private String type;            //结算类型
    private String level;           //挂号级别
    private Boolean isInvoice;      //是否开票
    private String invoiceCode;     //发票代码
    private String invoiceNumber;   //发票号


    /**
     * LocalDate对应的是yyyy-MM-dd
     * LocalDateTime对应的是yyyy-MM-dd HH:mm:ss
     */

    private LocalDate invoiceDate;       //开票日期

    /**
     * 科室部门Id
     */
    @TableField(exist = false)
    private Integer depId;

    /**
     * 挂号患者姓名
     */
    @TableField(exist = false)
    private String patientName;

    /**
     * 挂号患者性别
     */
    @TableField(exist = false)
    private Integer ssex;

    /**
     * 挂号患者生日
     */
    @TableField(exist = false)
    private Date birthday;

    /**
     * 挂号医生姓名
     */
    @TableField(exist = false)
    private String doctorName;

    /**
     * 挂号患者年龄
     */
    @TableField(exist = false)
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.setAge(AgeFromBirthdayUtil.getCurrentAge(birthday));
    }
}
