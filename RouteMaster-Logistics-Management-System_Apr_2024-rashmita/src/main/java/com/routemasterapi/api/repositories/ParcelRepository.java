
package com.routemasterapi.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.ParcelEntity;
 
@Repository
public interface  ParcelRepository extends CrudRepository<ParcelEntity,Integer> {

	@Query(value = "SELECT count(*) from urja_parcel", nativeQuery = true)
	String countNumberOfParcels();
	
	@Query(value = "SELECT t.parcelStatus, COUNT(*) AS total FROM urja_parcel_trackparcel pt JOIN indranil_trackparcel t ON pt.trackParcelId = t.trackParcelId GROUP BY t.parcelStatus;", nativeQuery = true)
	List<Object[]> totalParcelsByRoute();
	
	@Query(value = "select * from  urja_parcel ", nativeQuery = true)
	Page<ParcelEntity> listallparcelsfromdb(Pageable pageable);
	
	@Query(value = "SELECT * FROM urja_parcel WHERE customerId = :customerId", nativeQuery = true)
	Page<ParcelEntity> listcustomerparcelstatusfromdb(@Param("customerId") int customerId, Pageable pageable);

	@Query(value = "SELECT * FROM urja_parcel WHERE addedOn >= :oneMonthAgo ", nativeQuery = true)
	Page<ParcelEntity> listonemonthparcelsfromdb(@Param("oneMonthAgo") LocalDate oneMonthAgo, Pageable pageable);
	
	@Query(value = "SELECT * FROM urja_parcel WHERE addedOn >= :oneMonthAgo AND parcelStatus = 'Delayed' ", nativeQuery = true)
	Page<ParcelEntity> listonemonthdelayedparcelsfromdb(@Param("oneMonthAgo") LocalDate oneMonthAgo, Pageable pageable);

}
