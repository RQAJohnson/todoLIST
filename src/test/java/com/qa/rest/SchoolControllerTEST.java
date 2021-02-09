package com.qa.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.SchoolService;

public class SchoolControllerTEST {
	
	@RestController
	@RequestMapping("/school")
	public class SchoolController {
		
		private SchoolService service;

		public SchoolController(SchoolService service) {
			super();
			this.service = service;
		}
			
			
//		TEST	

	}
}
