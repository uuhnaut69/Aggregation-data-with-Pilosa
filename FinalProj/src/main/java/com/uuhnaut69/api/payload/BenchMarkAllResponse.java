package com.uuhnaut69.api.payload;

import java.util.List;

import com.uuhnaut69.api.entity.view.ImageView;

import lombok.Data;

/**
 * @author uuhnaut
 *
 */
@Data
public class BenchMarkAllResponse {
	private List<ImageView> list;
	private long runTime;
}
