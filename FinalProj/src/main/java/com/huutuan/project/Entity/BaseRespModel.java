package com.huutuan.project.Entity;

/**
 * @author uuhnaut
 *
 */
public class BaseRespModel {
	private long totalRecord;
	private long pageNo;
	private long pageSize;
	private long fromRecord;
	private long toRecord;

	/**
	 * @return the totalRecord
	 */
	public long getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the pageNo
	 */
	public long getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public long getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the fromRecord
	 */
	public long getFromRecord() {
		return fromRecord;
	}

	/**
	 * @param fromRecord the fromRecord to set
	 */
	public void setFromRecord(long fromRecord) {
		this.fromRecord = fromRecord;
	}

	/**
	 * @return the toRecord
	 */
	public long getToRecord() {
		return toRecord;
	}

	/**
	 * @param toRecord the toRecord to set
	 */
	public void setToRecord(long toRecord) {
		this.toRecord = toRecord;
	}

}
