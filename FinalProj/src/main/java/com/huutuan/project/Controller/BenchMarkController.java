package com.huutuan.project.Controller;

import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.ImageRespModel;
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

	@GetMapping("/mysql/image/fetchAll")
	public ImageRespModel mysqlBenchMark() {
		long mysqlStart = new DateTime().getMillis();
		ImageRespModel respModel = new ImageRespModel();
		respModel.setList(mySqlService.getAll());
		long mysqlEnd = new DateTime().getMillis();
		long mysqlRuntime = mysqlEnd - mysqlStart;
		respModel.setRunTime(mysqlRuntime);
		return respModel;
	}

	@GetMapping("/mysql/image/{id}")
	public Map<String, Object> mysqlBenchMarkById(@PathVariable int id) {
		Map<String, Object> respModel = mySqlService.getById(id);
		return respModel;
	}

	@GetMapping("/pilosa/image/{id}")
	public Map<String, Object> pilosaBenchMarkById(@PathVariable int id) {
		Map<String, Object> respModel = pilosaService.getById(id);
		return respModel;
	}

	@GetMapping("/pilosa/image/fetchAll")
	public ImageRespModel pilosaBenchMark() {
		long PqlStart = new DateTime().getMillis();
		ImageRespModel respModel = new ImageRespModel();
		respModel.setList(pilosaService.getAll());
		long PqlEnd = new DateTime().getMillis();
		long PqlRuntime = PqlEnd - PqlStart;
		respModel.setRunTime(PqlRuntime);
		return respModel;
	}
}
