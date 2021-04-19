package world.keyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import world.keyi.bean.Door;
import world.keyi.service.DoorService;

import java.util.List;

/**
 * @author 万一
 * @date 2021年04月19日10:50
 */
@Controller
public class DoorController {

    @Autowired
    private DoorService doorService;

    @RequestMapping("/doorList")
    public ModelAndView doorList(){
        List<Door> doors = doorService.getAllDoor();
        ModelAndView modelAndView = new ModelAndView("door_list");
        modelAndView.addObject("list",doors);
        return modelAndView;
    }

    @RequestMapping(value = "/door_add",method = RequestMethod.POST)
    public String door_add(Door door){
        doorService.addDoor(door);
        return "redirect:/doorList";
    }

    @RequestMapping("/door_delete")
    public String door_delete(@RequestParam("id") Integer id){
        doorService.deleteDoor(id);
        return "redirect:/doorList";
    }

    @RequestMapping("/door_update")
    public String door_update(Door door){
        doorService.updateDoor(door);
        return "redirect:/doorList";
    }
}
