package com.huutuan.project.Entity;

import java.util.List;
import java.util.Map;

public class ImageRespModel {

	private List<Map<String, Object>> list;
	private long runTime;

	/**
	 * @return the list
	 */
	public List<Map<String, Object>> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	/**
	 * @return the runTime
	 */
	public long getRunTime() {
		return runTime;
	}

	/**
	 * @param runTime the runTime to set
	 */
	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}

}
