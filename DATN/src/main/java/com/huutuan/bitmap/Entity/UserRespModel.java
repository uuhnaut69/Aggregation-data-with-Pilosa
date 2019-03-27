package com.huutuan.bitmap.Entity;

import java.util.List;

public class UserRespModel extends SearchRespModel {
	private List<User> listUser;

	/**
	 * @return the listUser
	 */
	public List<User> getListUser() {
		return listUser;
	}

	/**
	 * @param listUser the listUser to set
	 */
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

}
