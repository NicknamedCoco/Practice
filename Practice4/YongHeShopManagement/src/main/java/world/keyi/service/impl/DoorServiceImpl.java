package world.keyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import world.keyi.bean.Door;
import world.keyi.mapper.DoorMapper;
import world.keyi.service.DoorService;

import java.util.List;

/**
 * @author 万一
 * @date 2021年04月19日10:48
 */
@Service
public class DoorServiceImpl implements DoorService {

    @Autowired
    private DoorMapper doorMapper;

    @Override
    public Door getDoorById(Integer id) {
        return doorMapper.getDoorById(id);
    }

    @Override
    public List<Door> getAllDoor() {
        return doorMapper.getAllDoor();
    }

    @Override
    public void addDoor(Door door) {
        doorMapper.addDoor(door);
    }

    @Override
    public Integer deleteDoor(Integer id) {

        return doorMapper.deleteDoor(id);
    }

    @Override
    public Integer updateDoor(Door door) {
        return doorMapper.updateDoor(door);
    }


}
