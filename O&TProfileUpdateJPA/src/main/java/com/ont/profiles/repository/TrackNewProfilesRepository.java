package com.ont.profiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ont.profiles.TrackNewProfiles;


@Repository
public interface TrackNewProfilesRepository extends JpaRepository<TrackNewProfiles, String> {

	@Query("SELECT np FROM TrackNewProfiles np WHERE np.firstTimeUpdate = false")
	List<TrackNewProfiles> returnAllNewProfiles();

}
