package com.uuhnaut69.api.payload;

import com.uuhnaut69.api.entity.view.ImageView;

import lombok.Data;

/**
 * @author uuhnaut
 *
 */
@Data
public class BenchMarkByIdResponse {
	private ImageView imageInfo;
	private long runTime;
}
