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
		return mySqlService.getById(id);
	}

	@GetMapping("/mysql/image/fetchAll")
	public BenchMarkAllRespModel mysqlBenchMark() {
		return mySqlService.getAll();
	}

	@GetMapping("/pilosa/image/{id}")
	public BenchMarkByIdRespModel pilosaBenchMarkById(@PathVariable int id) {
		return pilosaService.getById(id);
	}

	@GetMapping("/pilosa/image/fetchAll")
	public BenchMarkAllRespModel pilosaBenchMark() {
		return pilosaService.getAll();
	}

}
