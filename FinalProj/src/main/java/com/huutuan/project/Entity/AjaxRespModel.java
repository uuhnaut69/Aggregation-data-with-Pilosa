package com.huutuan.project.Entity;

import java.util.List;

/**
 * @author uuhnaut
 *
 */
public class AjaxRespModel {

	private List<Object[]> list;
	private Long mysqlRunTime;
	private Long pilosaRunTime;

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
	 * @return the mysqlRunTime
	 */
	public Long getMysqlRunTime() {
		return mysqlRunTime;
	}

	/**
	 * @param mysqlRunTime the mysqlRunTime to set
	 */
	public void setMysqlRunTime(Long mysqlRunTime) {
		this.mysqlRunTime = mysqlRunTime;
	}

	/**
	 * @return the pilosaRunTime
	 */
	public Long getPilosaRunTime() {
		return pilosaRunTime;
	}

	/**
	 * @param pilosaRunTime the pilosaRunTime to set
	 */
	public void setPilosaRunTime(Long pilosaRunTime) {
		this.pilosaRunTime = pilosaRunTime;
	}

}
