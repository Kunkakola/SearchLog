package com.yu.demo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.yu.demo.controller.HiveJdbcTemplateController;
import com.yu.demo.dto.LoginDto;
import com.yu.demo.dto.SearchLogDto;
import com.yu.demo.service.HiveJdbcTemplateService;

@Service("HiveJdbcTemplateService")
public class HiveJdbcTemplateServiceImpl implements HiveJdbcTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(HiveJdbcTemplateController.class);

    @Autowired
    @Qualifier("hiveJdbcTemplate")
    private JdbcTemplate hiveJdbcTemplate;

    @Override
    public LoginDto login(LoginDto loginDto) {
        StringBuilder sql = new StringBuilder();
        sql.append("select username, password from users ").append("where username='").append(loginDto.getUsername())
                .append("'");

        logger.info("Running: " + sql);
        String resultMsg = "login successfully...";
        List<LoginDto> result = new ArrayList<LoginDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(LoginDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "login encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        if (result.size() == 0) {
            loginDto.setCode("No Username");
            return loginDto;
        } else {
            LoginDto ret = result.get(0);
            if (ret.getPassword().equals(loginDto.getPassword())) {
                ret.setCode("YES");
            } else {
                ret.setCode("NO");
            }
            return ret;
        }

    }

    

    @Override
    public Integer qryRowCount(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(uid) from ").append(param);
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryRowCount successfully...";
        int result = 0;
        try {
            result = hiveJdbcTemplate.queryForObject(sql.toString(), Integer.class);
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryRowCount encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;

    }

    @Override
    public List<SearchLogDto> qryKeyWord(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select keyWord,count(uid) as count from  ").append(param)
                .append("  group by keyWord order by count desc limit 20 ");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryKeyWord successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryKeyWord encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryUrl(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select url,count(uid) as count from  ").append(param)
                .append("  group by url order by count desc limit 20 ");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryUrl successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryUrl encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryUser(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select uid,count(uid) as count from  ").append(param)
                .append("  group by uid order by count desc limit 20 ");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryUser successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryUser encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryKeyWordCloud(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select keyWord as name,count(uid) as value from  ").append(param)
                .append("  group by keyWord order by value desc limit 100 ");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryKeyWordCloud successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryKeyWordCloud encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryUserCount(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count as name, count(uid) as value from (select uid, count(keyWord) as count from ")
                .append(param).append(" GROUP BY uid order by count desc) t group by count order by value desc");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryUserCount successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryUserCount encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryUrlCount(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select  '查询词为url' as name, count(keyWord) as value from ").append(param)
                .append(" where keyWord like '%www%'");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryUrlCount successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryUrlCount encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryPeriod(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select MINUTE(time) as name, count(uid) as value from ").append(param)
                .append(" group by MINUTE(time) order by name asc");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryPeriod successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryPeriod encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public List<SearchLogDto> qryAnomalyDetection(String param) {
        StringBuilder sql = new StringBuilder();
        sql.append("select uid,MINUTE(time) as name, count(keyWord) as count from ").append(param)
                .append(" group by uid,MINUTE(time) having count>5 order by count desc");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "qryAnomalyDetection successfully...";
        List<SearchLogDto> result = new ArrayList<SearchLogDto>();
        try {
            result = hiveJdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(SearchLogDto.class));
            logger.info(resultMsg);
        } catch (DataAccessException dae) {
            resultMsg = "qryAnomalyDetection encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
        }
        return result;
    }

    @Override
    public String doImport(String fileName) {
        StringBuilder sql = new StringBuilder();
        sql.append("load data local inpath '/mnt/hgfs/").append(fileName)
                .append("' overwrite into table log_sample");
        // .append("where 1 = 1");

        logger.info("Running: " + sql);
        String resultMsg = "doImport successfully...";
        try {
            hiveJdbcTemplate.execute(sql.toString());
            logger.info(resultMsg);
            return "导入成功";
        } catch (DataAccessException dae) {
            resultMsg = "doImport encounter an error: " + dae.getMessage();
            logger.error(resultMsg);
            return "导入失败";
        }
    }

}
