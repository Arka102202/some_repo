package com.jpaTransaction.demo;

import com.jpaTransaction.demo.entity.Course;
import com.jpaTransaction.demo.entity.Standard;
import com.jpaTransaction.demo.entity.Student;
import com.jpaTransaction.demo.entity.StudentPersonalDetails;
import com.jpaTransaction.demo.repository.CourseRepo;
import com.jpaTransaction.demo.repository.StandardRepo;
import com.jpaTransaction.demo.repository.StudentPersonalDetailsRepo;
import com.jpaTransaction.demo.repository.StudentRepo;
import com.jpaTransaction.demo.service.StudentPersonalDetailsService;
import com.jpaTransaction.demo.service.StudentPersonalDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringJpaTransactionDemoApplication implements CommandLineRunner {

//	@Autowired
//	private StandardRepo standardRepo;
	@Autowired
	private StudentRepo studentRepo;
//	@Autowired
//	private CourseRepo courseRepo;

//	@Autowired
//	private StudentPersonalDetailsRepo detailsRepo;



	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTransactionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Student s1 = Student.builder()
				.name("arkadyuti")
				.email("789456123.sikdar@gmail.com")
				.ph("7384731979")
				.id(0L)
				.pd(StudentPersonalDetails.builder().id(0).hobby("photography").city("ashokenagr").build())
				.build();
		Student s2 = Student.builder()
				.name("joyeeta")
				.email("joyeetadas7479@gmail.com")
				.ph("7479384999")
				.id(0L)
				.pd(StudentPersonalDetails.builder().id(0).hobby("me").city("Ggobardanga").build())
				.build();

		Standard standard = Standard.builder().id(0).name("12th standard").build();

		Course c1 = Course.builder().id(0).name("science").type("compulsory").build();
		Course c2 = Course.builder().id(0).name("arts").type("compulsory").build();
		Course c3 = Course.builder().id(0).name("com-arts").type("compulsory").build();

//		s1.setCourseList(List.of(c1,c2));
//		s2.setCourseList(List.of(c1,c2));
//		s1.setStandard(standard);
//		s2.setStandard(standard);



//		studentRepo.deleteAll();
//		standardRepo.deleteAll();
//		courseRepo.deleteAll();
//
//
//		standardRepo.save(standard);
//		courseRepo.saveAll(List.of(c1,c2,c3));
		studentRepo.saveAll(List.of(s1,s2));

//		Student student = studentRepo.findAll().get(0);
//		System.out.println(student);
//		System.out.printf(courseRepo.getByStudentId(studentRepo.findAll().get(0).getPd(service)));

//		System.out.println(detailsRepo.getStudentPersonalDetailsByStudent(student));



	}
}
