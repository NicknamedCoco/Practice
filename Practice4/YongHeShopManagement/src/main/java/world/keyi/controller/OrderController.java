package world.keyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.keyi.bean.Door;
import world.keyi.bean.Order;
import world.keyi.service.DoorService;
import world.keyi.service.OrderService;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author 万一
 * @date 2021年04月19日13:55
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DoorService doorService;

    @RequestMapping("/orderList")
    public String orderList(Model model){
        List<Order> orders = orderService.getAllOrder();
        List<Door> doors = doorService.getAllDoor();
        model.addAttribute("doorList",doors);
        model.addAttribute("orderList",orders);
        System.out.println("doorList:"+doors);
        System.out.println("orderList"+orders);
        return "order_list";
    }

    @RequestMapping("/order_add")
    public String order_add(Order order){
        order.setOrderTime(new Date());
        order.setPayTime(new Date());
        System.out.println(order);
        orderService.addOrder(order);
        return "redirect:/orderList";
    }

    @RequestMapping("/order_delete")
    public String order_delete(@RequestParam("id")Integer id){
        orderService.deleteOrder(id);
        return "redirect:/orderList";
    }

    @RequestMapping("/order_update")
    public String order_update(Order order){
        orderService.updateOrder(order);
        return "redirect:/orderList";
    }
}
