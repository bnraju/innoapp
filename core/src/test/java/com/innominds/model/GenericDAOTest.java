package com.innominds.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.innominds.dao.GenericDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/applicationContext.xml" })
public class GenericDAOTest{

	@Autowired
	GenericDao genericDao;

	
	
	@Test
	public void testSaveEntity(){
		try {
			/*User user=new User();
			user.setUserID("0012");
			user.setFirstName("test");
			user.setLastName("case");
			user.setDob(new Date());
			user.setPassword("sruthi");
			System.out.println("GenericDAOTest.testSaveEntity()");*/
			CountryEntity user = new CountryEntity();
			user.setCountryName("India");
			user.setCountryDesc("desc");
			user.setCountryCode("code");
			user.setCountryId("122");
			genericDao.create(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
}
