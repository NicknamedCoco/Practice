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

import java.util.List;

/**
 * @author 万一
 * @date 2021年04月19日13:20
 */
@Controller
public class PageController {

    @Autowired
    private DoorService doorService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/top")
    public String _top(){
        return "_top";
    }

    @RequestMapping("/left")
    public String _left(){
        return "_left";
    }

    @RequestMapping("/right")
    public String _right(){
        return "_right";
    }

    @RequestMapping("/door_add_Page")
    public String door_add(){
        return "door_add";
    }

    @RequestMapping("/door_update_page")
    public String door_update(@RequestParam("id")Integer id, Model model){
        Door door = doorService.getDoorById(id);
        model.addAttribute("door",door);
        return "door_update";
    }

    @RequestMapping("/order_add_page")
    public String order_add(Model model){
        List<Door> doors = doorService.getAllDoor();
        model.addAttribute("doorList",doors);
        return "order_add";
    }

    @RequestMapping("/order_update_page")
    public String order_update(@RequestParam("id") Integer id,Model model){
        List<Door> doors = doorService.getAllDoor();
        Order order = orderService.getOrderById(id);
        model.addAttribute("doorList",doors);
        model.addAttribute("order",order);
        return "order_update";
    }

}
