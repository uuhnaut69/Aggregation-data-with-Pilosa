package com.huutuan.bitmap.Utils;

import com.huutuan.bitmap.Entity.SearchRespModel;

/**
 * @author uuhnaut
 *
 */
public class CalculateIndex {
	/**
	 * @param model
	 * @return
	 */
	public static SearchRespModel calculateIndexInPage(SearchRespModel model) {
		int totalRecord = model.getTotalRecord();
		int pageNo = model.getPageNo();
		int pageSize = model.getPageSize();

		if (pageNo <= 0 || totalRecord <= 0 || pageSize <= 0) {
			model.setFromRecord(0);
			model.setToRecord(0);
			return model;
		}

		int fromRecord = (pageNo - 1) * pageSize + 1;
		int toRecord = fromRecord + pageSize - 1;
		if (toRecord > totalRecord) {
			toRecord = totalRecord;
		}
		model.setFromRecord(fromRecord);
		model.setToRecord(toRecord);

		return model;
	}
}
