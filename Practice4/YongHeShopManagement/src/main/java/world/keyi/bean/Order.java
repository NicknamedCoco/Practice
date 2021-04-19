package world.keyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 万一
 * @date 2021年04月19日10:32
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Configuration
public class Order {
    private Integer id;
    private Integer doorId;
    private String orderNo;
    private String orderType;
    private Integer pnum;
    private String cashier;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    private String payType;
    private Double price;
    private Door door;
}
