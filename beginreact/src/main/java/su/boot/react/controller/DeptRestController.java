package su.boot.react.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import su.boot.react.entity.Dept;
import su.boot.react.service.DeptService;

@RestController
@RequiredArgsConstructor
public class DeptRestController {
	private static final Logger logger = LogManager.getLogger(DeptRestController.class);

	@Inject
	private final DeptService deptService;

	@GetMapping("/selectAll")
	public List<Dept> getAllDepts() {
		return deptService.findAllDepts();
	}

	@GetMapping("/select/{deptno}")
	public ResponseEntity<Dept> getDeptById(@PathVariable("deptno") Integer deptno) {
		Dept dept = deptService.findDeptById(deptno);
		logger.info("dept", dept);
		if (dept != null) {
			return new ResponseEntity<>(dept, HttpStatus.OK);
	} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<String> createDept(@RequestBody Dept dept) {
		if (deptService.existsByDeptno(dept.getDeptno())) {
			return new ResponseEntity<>("부서 번호가 이미 존재합니다.", HttpStatus.BAD_REQUEST);
		}
		Dept dept2 = deptService.saveDept(dept);
		logger.info("dept", dept2);
		return new ResponseEntity<>("부서가 성공적으로 저장되었습니다.", HttpStatus.CREATED);
	}

	@PutMapping("/update/{deptno}")
	public ResponseEntity<Dept> updateDept(@PathVariable("deptno") Integer deptno, @RequestBody Dept deptDetails) {
		Dept dept = deptService.findDeptById(deptno);
		if (dept != null) {
			dept.setDname(deptDetails.getDname());
			dept.setLoc(deptDetails.getLoc());
			Dept dept2 = deptService.saveDept(dept);
			return new ResponseEntity<>(dept2, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{deptno}")
	public ResponseEntity<HttpStatus> deleteDept(@PathVariable("deptno") Integer deptno) {
		deptService.deleteDeptById(deptno);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
