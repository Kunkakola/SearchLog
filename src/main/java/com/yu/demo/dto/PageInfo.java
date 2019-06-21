package com.yu.demo.dto;

import java.util.List;

public class PageInfo<T> {

    // 当前页
    private Integer current;

    // 每页记录数
    private Integer rowCount;

    // 结果集
    private List<T> rows;

    // 总记录数
    private Integer total;

    public PageInfo() {
    }

    public PageInfo (List<T> list) {
        this.setCurrent(1);
        this.setRowCount(10);
        this.setRows(list);
        this.setTotal(list.size());
    }


	/**
     * @return the current
     */
    public Integer getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Integer current) {
        this.current = current;
    }

    /**
     * @return the rowCount
     */
    public Integer getRowCount() {
        return rowCount;
    }

    /**
     * @param rowCount the rowCount to set
     */
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    /**
     * @return the rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}