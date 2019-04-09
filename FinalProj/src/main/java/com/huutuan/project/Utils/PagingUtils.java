package com.huutuan.project.Utils;

import com.huutuan.project.Entity.BaseRespModel;

/**
 * @author uuhnaut
 *
 */
public class PagingUtils {

	public static BaseRespModel calculateIndexInPage(BaseRespModel model) {
		long totalRecord = model.getTotalRecord();
		long pageNo = model.getPageNo();
		long pageSize = model.getPageSize();

		if (pageNo <= 0 || totalRecord <= 0 || pageSize <= 0) {
			model.setFromRecord(0);
			model.setToRecord(0);
			return model;
		}

		long fromRecord = (pageNo - 1) * pageSize + 1;
		long toRecord = fromRecord + pageSize - 1;
		if (toRecord > totalRecord) {
			toRecord = totalRecord;
		}
		model.setFromRecord(fromRecord);
		model.setToRecord(toRecord);

		return model;
	}

}
