package com.huutuan.project.Entity;

public class BenchMarkByIdRespModel {
	private ImageInfo imageInfo;
	private long runTime;

	/**
	 * @return the imageInfo
	 */
	public ImageInfo getImageInfo() {
		return imageInfo;
	}

	/**
	 * @param imageInfo the imageInfo to set
	 */
	public void setImageInfo(ImageInfo imageInfo) {
		this.imageInfo = imageInfo;
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
