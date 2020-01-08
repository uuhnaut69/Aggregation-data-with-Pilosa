package com.uuhnaut69.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.payload.BenchMarkAllResponse;
import com.uuhnaut69.api.payload.BenchMarkByIdResponse;
import com.uuhnaut69.api.service.MysqlQueryService;
import com.uuhnaut69.api.service.PilosaQueryService;

/**
 * @author uuhnaut
 *
 */
@RestController
public class BenchMarkController {

	private final MysqlQueryService mysqlQueryService;
	private final PilosaQueryService pilosaQueryService;

	public BenchMarkController(MysqlQueryService mysqlQueryService, PilosaQueryService pilosaQueryService) {
		this.mysqlQueryService = mysqlQueryService;
		this.pilosaQueryService = pilosaQueryService;
	}

	@GetMapping("/mysql/image/{id}")
	public BenchMarkByIdResponse mysqlBenchMarkById(@PathVariable Long id) throws Exception {
		return mysqlQueryService.getById(id);
	}

	@GetMapping("/mysql/image/fetchAll")
	public BenchMarkAllResponse mysqlBenchMark() {
		return mysqlQueryService.getAll();
	}

	@GetMapping("/pilosa/image/{id}")
	public BenchMarkByIdResponse pilosaBenchMarkById(@PathVariable Long id) throws Exception {
		return pilosaQueryService.getById(id);
	}

	@GetMapping("/pilosa/image/fetchAll")
	public BenchMarkAllResponse pilosaBenchMark() throws Exception {
		return pilosaQueryService.getAll();
	}

}
