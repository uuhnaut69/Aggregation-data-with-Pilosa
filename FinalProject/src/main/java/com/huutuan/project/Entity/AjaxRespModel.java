package com.huutuan.project.Entity;

import java.util.List;

/**
 * @author uuhnaut
 *
 */
public class AjaxRespModel {
	private List<Object[]> list;
	private Long mySqlQueryTime;

	/**
	 * @return the list
	 */
	public List<Object[]> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Object[]> list) {
		this.list = list;
	}

	/**
	 * @return the mySqlQueryTime
	 */
	public Long getMySqlQueryTime() {
		return mySqlQueryTime;
	}

	/**
	 * @param mySqlQueryTime the mySqlQueryTime to set
	 */
	public void setMySqlQueryTime(Long mySqlQueryTime) {
		this.mySqlQueryTime = mySqlQueryTime;
	}

}
