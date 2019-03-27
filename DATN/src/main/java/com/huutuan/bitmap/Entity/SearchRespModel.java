package com.huutuan.bitmap.Entity;

public class SearchRespModel {
	private Integer pageNo;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalRecord;
	private Integer fromRecord;
	private Integer toRecord;

	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalRecord
	 */
	public Integer getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the fromRecord
	 */
	public Integer getFromRecord() {
		return fromRecord;
	}

	/**
	 * @param fromRecord the fromRecord to set
	 */
	public void setFromRecord(Integer fromRecord) {
		this.fromRecord = fromRecord;
	}

	/**
	 * @return the toRecord
	 */
	public Integer getToRecord() {
		return toRecord;
	}

	/**
	 * @param toRecord the toRecord to set
	 */
	public void setToRecord(Integer toRecord) {
		this.toRecord = toRecord;
	}

}
