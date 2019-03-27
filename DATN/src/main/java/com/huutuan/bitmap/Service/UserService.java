package com.huutuan.bitmap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huutuan.bitmap.Entity.User;
import com.huutuan.bitmap.Entity.UserRespModel;
import com.huutuan.bitmap.Repository.UserRepository;
import com.huutuan.bitmap.Utils.CalculateIndex;
import com.huutuan.bitmap.Utils.NumberUtils;

/**
 * @author uuhnaut
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public UserRespModel getDataSearch(int pageNo, int pageSize) {
		UserRespModel respModel = new UserRespModel();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		Page<User> userPage = repo.findAll(pageable);

		List<User> listUser = userPage.getContent();
		respModel.setListUser(listUser);
		respModel.setPageNo(NumberUtils.nvl(pageNo, 0));
		respModel.setPageSize(NumberUtils.nvl(pageSize, 0));
		respModel.setTotalRecord(Math.toIntExact(userPage.getTotalElements()));
		respModel.setTotalPage(userPage.getTotalPages());
		CalculateIndex.calculateIndexInPage(respModel);

		return respModel;
	}
}