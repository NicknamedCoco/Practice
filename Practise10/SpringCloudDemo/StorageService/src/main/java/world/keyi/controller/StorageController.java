package world.keyi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import world.keyi.result.CommonResult;
import world.keyi.service.StorageService;

import javax.annotation.Resource;

/**
 * @author 万一
 * @date 2021年11月15日18:30
 */
@RestController
@RefreshScope
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @Value("${info}")
    private String info;

    @RequestMapping("/nacos")
    public String nacosTest(){
        return info;
    }

    @PutMapping("/")
    public CommonResult<Integer> reduceStorage(@RequestParam("productId") String productId,@RequestParam("count") String count){
        return new CommonResult<>(200,"success",storageService.reduceStorage(productId,count));
    }
}
