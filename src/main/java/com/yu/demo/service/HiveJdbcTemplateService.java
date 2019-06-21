package com.yu.demo.service;

import java.util.List;

import com.yu.demo.dto.LoginDto;
import com.yu.demo.dto.SearchLogDto;

import org.springframework.stereotype.Service;

@Service
public interface HiveJdbcTemplateService {
    
    public LoginDto login(LoginDto loginDto);

    public String doImport(String fileName);

    public Integer qryRowCount(String param);

    public List<SearchLogDto> qryKeyWord(String param);

    public List<SearchLogDto> qryUrl(String param);

    public List<SearchLogDto> qryUser(String param);

    public List<SearchLogDto> qryKeyWordCloud(String param);

    public List<SearchLogDto> qryUserCount(String param);

    public List<SearchLogDto> qryUrlCount(String param);

    public List<SearchLogDto> qryPeriod(String param);

    public List<SearchLogDto> qryAnomalyDetection(String param);
}
