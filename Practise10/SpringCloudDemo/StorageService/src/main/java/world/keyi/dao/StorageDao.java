package world.keyi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    Integer reduceStorage(@Param("productId") String productId,@Param("count") String count);
}
