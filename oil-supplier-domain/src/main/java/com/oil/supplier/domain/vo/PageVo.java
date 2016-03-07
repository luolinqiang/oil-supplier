package com.oil.supplier.domain.vo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-4
 * Time: 下午9:53
 * To change this template use File | Settings | File Templates.
 */
public class PageVo extends VoBaseObject {

    private static final long serialVersionUID = 1L;

    private Integer pageIndex;

    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
