package world.keyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.keyi.bean.Door;

import java.util.List;

@Mapper
public interface DoorMapper {
    public Door getDoorById(Integer id);

    public List<Door> getAllDoor();

    public void addDoor(Door door);

    public Integer deleteDoor(Integer id);

    public Integer updateDoor(Door door);
}
