package world.keyi.service;

import world.keyi.bean.Door;

import java.util.List;

public interface DoorService {
    public Door getDoorById(Integer id);

    public List<Door> getAllDoor();

    public void addDoor(Door door);

    public Integer deleteDoor(Integer id);

    public Integer updateDoor(Door door);
}
