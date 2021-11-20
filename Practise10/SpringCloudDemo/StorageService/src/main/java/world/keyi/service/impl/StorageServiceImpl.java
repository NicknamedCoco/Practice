package world.keyi.service.impl;

import org.springframework.stereotype.Service;
import world.keyi.dao.StorageDao;
import world.keyi.service.StorageService;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年11月15日18:31
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public Integer reduceStorage(String productId, String count) {
        return storageDao.reduceStorage(productId,count);
    }
}
