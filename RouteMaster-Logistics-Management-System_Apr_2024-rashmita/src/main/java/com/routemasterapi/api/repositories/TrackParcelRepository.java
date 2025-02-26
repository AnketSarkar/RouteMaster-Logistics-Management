
package com.routemasterapi.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.TrackParcelEntity;
 
@Repository
public interface  TrackParcelRepository extends CrudRepository<TrackParcelEntity,Integer> {
	
//	@Query(value = "SELECT count(*) from urja_trackparcel WHERE approveReject = 'approve'", nativeQuery = true)
//	int totalCompletePaymentParcels();
	
	@Query(value = "SELECT SUM(p.parcelPrice) AS totalPaymentsDelivered FROM urja_parcel_trackparcel pt INNER JOIN urja_trackparcel t ON pt.trackParcelId = t.trackParcelId INNER JOIN indranil_parcel p ON pt.parcelId = p.parcelId WHERE t.parcelStatus = 'delivered';", nativeQuery = true)
	int totalCompletePaymentParcels();
	
	@Query(value = "select * from  urja_trackparcel ", nativeQuery = true)
	Page<TrackParcelEntity> listalltrackparcelsfromdb(Pageable pageable);



}
