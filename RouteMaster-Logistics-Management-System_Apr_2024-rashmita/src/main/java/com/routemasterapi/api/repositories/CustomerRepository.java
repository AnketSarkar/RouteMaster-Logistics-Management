
package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository <CustomerEntity, Integer>  {
	
	@Query(value = "SELECT count(*) from urja_customer", nativeQuery = true)
	String countNumberOfCustomers();

	@Query(value = "select * from  urja_customer ", nativeQuery = true)
	Page<CustomerEntity> listallcustomersfromdb(Pageable pageable);
	
}
