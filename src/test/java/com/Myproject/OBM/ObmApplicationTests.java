package com.Myproject.OBM;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.UserrRepo;
import com.Myproject.OBM.servises.AdminService;
import com.Myproject.OBM.servises.UserrService;

@SpringBootTest(classes= ObmApplication.class)
class ObmApplicationTests {
	
	private UserrRepo userRepo;
	
	private AdminService adminService;
	
	private UserrService userService;
//
//	@Test
//	public void getUserTest() {
//		when(userRepo.findAll())
//		.thenReturn(Stream.of(new Userr(3,"rohan@gmil.com","rohan","rohan123", null)).collect(Collectors.toList()));
//		assertEquals(1,userService.fetchAllUser().size());
//	}

}
