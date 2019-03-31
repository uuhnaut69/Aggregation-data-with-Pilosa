package com.huutuan.project.Entity;

import java.util.List;

/**
 * @author uuhnaut
 *
 */
public class AjaxRespModel {
	private List<LikeShare> list;
	private Long queryTime;

	/**
	 * @return the list
	 */
	public List<LikeShare> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<LikeShare> list) {
		this.list = list;
	}

	/**
	 * @return the queryTime
	 */
	public Long getQueryTime() {
		return queryTime;
	}

	/**
	 * @param queryTime the queryTime to set
	 */
	public void setQueryTime(Long queryTime) {
		this.queryTime = queryTime;
	}

}
