package com.huutuan.project.Entity;

import java.util.List;

public class BenchMarkAllRespModel {
	private List<ImageInfo> list;
	private long runTime;

	/**
	 * @return the list
	 */
	public List<ImageInfo> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<ImageInfo> list) {
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
