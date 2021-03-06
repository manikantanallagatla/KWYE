package com.iitr.kwue.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iitr.kwue.Constants.QueryConstants;
import com.iitr.kwue.entities.FoodDisease;
import com.iitr.kwue.model.FoodDiseaseId;


@Repository
public interface FoodDiseaseRepository extends CrudRepository<FoodDisease, FoodDiseaseId> {

	//@Query(value=QueryConstants.FETCH_STUDENT_BY_NAME,nativeQuery = true)
	//public Student fetchStudentByName(String name);

	@Modifying
	@Transactional
	@Query(value="update student s  set s.age = ?1 , s.mailid = ?2 ,s.name= ?3 where s.id = ?4",nativeQuery = true)
	void updateStudentInfoById(Integer age, String mailid, String name,Integer id);
	
//	@Query(value="SELECT * FROM food_disease fd where fd.food=:name",nativeQuery = true)
//	List<FoodDisease> findbyfood(@Param("name") String name);
//	
	@Query(value="SELECT * FROM food_disease fd where fd.food=?1",nativeQuery = true)
	List<FoodDisease> findbyfood(String name);
	
	@Query(value="SELECT * FROM food_disease fd where fd.disease=?1",nativeQuery = true)
	List<FoodDisease> findbydisease(String name);
}