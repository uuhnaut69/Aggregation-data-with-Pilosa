package com.huutuan.bitmap.Entity;

import java.util.List;

public class VideoRespModel extends SearchRespModel {
	private List<Video> listVideo;

	/**
	 * @return the listVideo
	 */
	public List<Video> getListVideo() {
		return listVideo;
	}

	/**
	 * @param listVideo the listVideo to set
	 */
	public void setListVideo(List<Video> listVideo) {
		this.listVideo = listVideo;
	}

}
