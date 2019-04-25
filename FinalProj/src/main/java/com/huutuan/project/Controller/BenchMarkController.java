package com.huutuan.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.BenchMarkAllRespModel;
import com.huutuan.project.Entity.BenchMarkByIdRespModel;
import com.huutuan.project.Service.MySqlService;
import com.huutuan.project.Service.PilosaService;

/**
 * @author uuhnaut
 *
 */
@RestController
public class BenchMarkController {

	@Autowired
	private PilosaService pilosaService;
	@Autowired
	private MySqlService mySqlService;

	@GetMapping("/mysql/image/{id}")
	public BenchMarkByIdRespModel mysqlBenchMarkById(@PathVariable int id) {
		BenchMarkByIdRespModel respModel = mySqlService.getById(id);
		return respModel;
	}

	@GetMapping("/mysql/image/fetchAll")
	public BenchMarkAllRespModel mysqlBenchMark() {
		BenchMarkAllRespModel respModel = mySqlService.getAll();
		return respModel;
	}

	@GetMapping("/pilosa/image/{id}")
	public BenchMarkByIdRespModel pilosaBenchMarkById(@PathVariable int id) {
		BenchMarkByIdRespModel respModel = pilosaService.getById(id);
		return respModel;
	}

	@GetMapping("/pilosa/image/fetchAll")
	public BenchMarkAllRespModel pilosaBenchMark() {
		BenchMarkAllRespModel respModel = pilosaService.getAll();
		return respModel;
	}

}
