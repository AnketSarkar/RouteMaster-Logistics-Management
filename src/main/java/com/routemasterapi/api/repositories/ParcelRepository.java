package com.routemasterapi.api.repositories;

import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.model.ParcelRequestBody;
 
@Repository
public interface  ParcelRepository extends CrudRepository<ParcelEntity,Integer> {

	@Query(value = "select * from  ayush_parcel ", nativeQuery = true)
	Page<ParcelEntity> listallparcelsfromdb(Pageable pageable);



}
