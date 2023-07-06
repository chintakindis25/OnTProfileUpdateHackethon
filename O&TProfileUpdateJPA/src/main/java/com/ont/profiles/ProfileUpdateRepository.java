package com.ont.profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileUpdateRepository extends JpaRepository<EmpProfile, String>{

	@Query("SELECT ep FROM EmpProfile ep WHERE ep.soeid = ?1")
	EmpProfile findBySOEID(String inputSOEID);

}
