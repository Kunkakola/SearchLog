package com.yu.demo.dto;

public class SogouDataDto {

    /**
     * 访问时间  <br>
     */
    private String time;
    
    /**
     * 用户ID <br>
     */
    private String uid;
    
    /**
     * 查询词  <br>
     */
    private String keyWord;
    
    /**
     * 该URL在返回结果中的排名  <br>
     */
    private Integer rank;
    
    /**
     * 用户点击的顺序号  <br>
     */
    private Integer sorder;
    
    /**
     * 查用户点击的URL <br>
     */
    private String url;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getSorder() {
        return sorder;
    }

    public void setSorder(Integer sorder) {
        this.sorder = sorder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
