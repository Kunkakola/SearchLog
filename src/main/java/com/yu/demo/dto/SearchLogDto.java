package com.yu.demo.dto;


public class SearchLogDto/* implements RowMapper */ {

    /**
     * 访问时间 <br>
     */
    private String time;

    /**
     * 用户ID <br>
     */
    private String uid;

    /**
     * 查询词 <br>
     */
    private String keyWord;

    /**
     * 该URL在返回结果中的排名 和 用户点击的顺序号 <br>
     * 因为在导入时无法分解成两个Integer，所以暂时拼成一个字符串
     */
    private String rank_sorder;

    /**
     * 查用户点击的URL <br>
     */
    private String url;

    /**
     * 查询结果中的各种count <br>
     */
    private Integer count;

    /**
     * 饼图和词云使用 <br>
     */
    private String name;

    /**
     * 饼图和词云使用 <br>
     */
    private Integer value;

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
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

    /**
     * @return the rank_sorder
     */
    public String getRank_sorder() {
        return rank_sorder;
    }

    /**
     * @param rank_sorder the rank_sorder to set
     */
    public void setRank_sorder(String rank_sorder) {
        this.rank_sorder = rank_sorder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /*
     * @Override public SearchLogDto mapRow(ResultSet rs, int rowNum) throws
     * SQLException { SearchLogDto dto = new SearchLogDto(); SimpleDateFormat sdf =
     * new SimpleDateFormat("hh:mm:ss"); String strDate = rs.getString("time");
     * String uid = rs.getString("uid"); String keyWord = rs.getString("keyWord");
     * String rank_sorder = rs.getString("rank_sorder"); String url =
     * rs.getString("url"); Integer count = rs.getInt("count");
     * 
     * Date date = null; try { date = sdf.parse(strDate); } catch (ParseException e)
     * { e.printStackTrace(); } dto.setTime(date); // 可以直接写成rs.getDate()
     * dto.setUid(uid); dto.setKeyWord(keyWord); dto.setRank_sorder(rank_sorder);
     * dto.setUrl(url); dto.setCount(count); return dto; }
     */

}
