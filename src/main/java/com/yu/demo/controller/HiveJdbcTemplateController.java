package com.yu.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.yu.demo.service.HiveJdbcTemplateService;
import com.yu.demo.dto.LoginDto;
import com.yu.demo.dto.SearchLogDto;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/hive2")
@RestController
public class HiveJdbcTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(HiveJdbcTemplateController.class);

    @Autowired
    private HiveJdbcTemplateService hiveJdbcTemplateService;
    
    @RequestMapping(value={"/login"},method=RequestMethod.GET)
    @ApiOperation(value="登陆操作", notes="登陆操作")
    public LoginDto login(LoginDto loginDto){
        logger.info("enter login: --username: "+ loginDto.getUsername() + "  --password: "+ loginDto.getPassword());
        return hiveJdbcTemplateService.login(loginDto);
    }

    @RequestMapping(value={"/qryRowCount/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="测试Hive连接", notes="测试Hive连接，返回对应表的行数")
    public Integer qryRowCount(@PathVariable String tableName){
        logger.info("enter qryRowCount --tableName:"+tableName);
        return hiveJdbcTemplateService.qryRowCount(tableName);
    }

    @RequestMapping(value={"/qryKeyWord/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询频度排名", notes="查询频度排名（频度最高的前 20 词）")
    public List<SearchLogDto> qryKeyWord(@PathVariable String tableName){
        logger.info("enter qryKeyWord --tableName:"+tableName);
        /* List<SearchLogDto> result = hiveJdbcTemplateService.qryKeyWord(tableName);
        return new PageInfo<SearchLogDto>(result); */
        return hiveJdbcTemplateService.qryKeyWord(tableName);
    }

    @RequestMapping(value={"/qryUrl/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询url排名", notes="查询url排名（频度最高的前 20 词）")
    public List<SearchLogDto> qryUrl(@PathVariable String tableName){
        logger.info("enter qryUrl --tableName:"+tableName);
        return hiveJdbcTemplateService.qryUrl(tableName);
    }

    @RequestMapping(value={"/qryUser/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询user排名", notes="查询user排名（频度最高的前 20 词）")
    public List<SearchLogDto> qryUser(@PathVariable String tableName){
        logger.info("enter qryUser --tableName:"+tableName);
        return hiveJdbcTemplateService.qryUser(tableName);
    }

    @RequestMapping(value={"/qryKeyWordCloud/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询词云", notes="查询词云（频度最高的前 100 词）")
    public List<SearchLogDto> qryKeyWordCloud(@PathVariable String tableName){
        logger.info("enter keyWordCloud --tableName:"+tableName);
        
        return hiveJdbcTemplateService.qryKeyWordCloud(tableName);
    }

    @RequestMapping(value={"/qryUserCount/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询用户查询次数", notes="查询用户查询次数排行")
    public List<SearchLogDto> qryUserCount(@PathVariable String tableName){
        logger.info("enter qryUserCount --tableName:"+tableName);
        
        return hiveJdbcTemplateService.qryUserCount(tableName);
    }

    @RequestMapping(value={"/qryUrlCount/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询keyword为url的次数", notes="查询keyword为url")
    public List<SearchLogDto> qryUrlCount(@PathVariable String tableName){
        logger.info("enter qryUrlCount --tableName:"+tableName);
        
        return hiveJdbcTemplateService.qryUrlCount(tableName);
    }

    @RequestMapping(value={"/qryPeriod/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询每分钟访问数", notes="查询每分钟访问数")
    public List<SearchLogDto> qryPeriod(@PathVariable String tableName){
        logger.info("enter qryPeriod --tableName:"+tableName);
        
        return hiveJdbcTemplateService.qryPeriod(tableName);
    }

    @RequestMapping(value={"/qryAnomalyDetection/{tableName}"},method=RequestMethod.GET)
    @ApiOperation(value="查询异常用户", notes="查询在一分钟内查询超过20次的用户")
    public List<SearchLogDto> qryAnomalyDetection(@PathVariable String tableName){
        logger.info("enter qryAnomalyDetection --tableName:"+tableName);
        
        return hiveJdbcTemplateService.qryAnomalyDetection(tableName);
    }

}
