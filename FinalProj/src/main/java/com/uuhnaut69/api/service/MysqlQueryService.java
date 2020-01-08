package com.uuhnaut69.api.service;

import com.uuhnaut69.api.payload.BenchMarkAllResponse;
import com.uuhnaut69.api.payload.BenchMarkByIdResponse;

/**
 * @author uuhnaut
 *
 */
public interface MysqlQueryService {

	BenchMarkByIdResponse getById(Long id) throws Exception;

	BenchMarkAllResponse getAll();
}
