
package com.routemasterapi.api.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.routemasterapi.api.entity.CustomerEntity;
import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.entity.RouteEntity;
import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.model.ParcelRequestBody;
import com.routemasterapi.api.repositories.CustomerRepository;
import com.routemasterapi.api.repositories.ParcelRepository;
import com.routemasterapi.api.repositories.RouteRepository;
import com.routemasterapi.api.repositories.TrackParcelRepository;

import utils.DateUtils;

@Service
public class ParcelService  {

	@Autowired
	private ParcelRepository parcelRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private TrackParcelRepository trackParcelRepository;

	

	public ParcelEntity createParcel(ParcelRequestBody parcelReqBody) throws Exception {
		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(parcelReqBody.getCustomerId());
		CustomerEntity customer = optionalCustomer.orElseThrow(() -> new Error("No customer with this id") );
		
		Optional<RouteEntity> optionalRoute = routeRepository.findById(parcelReqBody.getRouteId());
		RouteEntity route = optionalRoute.orElseThrow(() -> new Error("No route with this id") );
		
		List<TrackParcelEntity> trackParcels = parcelReqBody.getTrackParcelId().stream()
                .map(trackParcelId -> trackParcelRepository.findById(trackParcelId)
                        .orElseThrow(() -> new IllegalArgumentException("No track parcel with id: " + trackParcelId)))
                .collect(Collectors.toList());
       

		ParcelEntity newParcel = new ParcelEntity();
		newParcel.setParcelType(parcelReqBody.getParcelType());
		newParcel.setParcelName(parcelReqBody.getParcelName());
		newParcel.setParcelPrice(parcelReqBody.getParcelPrice());
		newParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		newParcel.setDestinationPincode(parcelReqBody.getDestinationPincode());
		newParcel.setSenderName(parcelReqBody.getSenderName());
		newParcel.setReceiverName(parcelReqBody.getReceiverName());
		newParcel.setConsignmentNumber(parcelReqBody.getConsignmentNumber());
		newParcel.setImageUrl(parcelReqBody.getImageUrl());
		newParcel.setCustomer(customer);
		newParcel.setRoute(route);
		newParcel.setTrackParcel(trackParcels);
		try {
			newParcel.setAddedOn(DateUtils.parseDateString(parcelReqBody.getAddedOn()));
		} catch (ParseException e) {
			throw new Exception("Invalid date format: " + parcelReqBody.getAddedOn());
		}
		return parcelRepository.save(newParcel);		 
	}

	public ParcelEntity updateParcel(ParcelRequestBody parcelReqBody) throws Exception {
		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(parcelReqBody.getCustomerId());
		CustomerEntity customer = optionalCustomer.orElseThrow(() -> new Error("No customer with this id") );
		
		Optional<RouteEntity> optionalRoute = routeRepository.findById(parcelReqBody.getRouteId());
		RouteEntity route = optionalRoute.orElseThrow(() -> new Error("No route with this id") );
		
		List<TrackParcelEntity> trackParcels = parcelReqBody.getTrackParcelId().stream()
                .map(trackParcelId -> trackParcelRepository.findById(trackParcelId)
                        .orElseThrow(() -> new IllegalArgumentException("No track parcel with id: " + trackParcelId)))
                .collect(Collectors.toList());
			
		ParcelEntity newParcel = new ParcelEntity();
		newParcel.setParcelId(parcelReqBody.getParcelId());
		newParcel.setParcelType(parcelReqBody.getParcelType());
		newParcel.setParcelName(parcelReqBody.getParcelName());
		newParcel.setParcelPrice(parcelReqBody.getParcelPrice());
		newParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		newParcel.setDestinationPincode(parcelReqBody.getDestinationPincode());
		newParcel.setSenderName(parcelReqBody.getSenderName());
		newParcel.setReceiverName(parcelReqBody.getReceiverName());
		newParcel.setConsignmentNumber(parcelReqBody.getConsignmentNumber());
		newParcel.setImageUrl(parcelReqBody.getImageUrl());
		newParcel.setCustomer(customer);
		newParcel.setRoute(route);
		newParcel.setTrackParcel(trackParcels);
		try {
			newParcel.setAddedOn(DateUtils.parseDateString(parcelReqBody.getAddedOn()));
		} catch (ParseException e) {
			throw new Exception("Invalid date format: " + parcelReqBody.getAddedOn());
		}
		return parcelRepository.save(newParcel);		 
	}

	public Page<ParcelEntity> listallparcelsfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return parcelRepository.listallparcelsfromdb(pageable);
	}
	
	public Page<ParcelEntity> listcustomerparcelstatusfromdb(int pageNumber, int size, int customerId) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return parcelRepository.listcustomerparcelstatusfromdb(customerId, pageable);
	}
	
	public Page<ParcelEntity> listonemonthparcelsfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
		return parcelRepository.listonemonthparcelsfromdb(oneMonthAgo, pageable);
	}
	
	public Page<ParcelEntity> listonemonthdelayedparcelsfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
		return parcelRepository.listonemonthdelayedparcelsfromdb(oneMonthAgo, pageable);
	}
 
 
	public String deleteParcel(ParcelIdRequest parcelIdReq) {
		int ParcelId= parcelIdReq.getParcelId();
		parcelRepository.deleteById(ParcelId);
		return "Record Deleted";
	}
	
	public String totalNoOfParcelsSent() {
		return parcelRepository.countNumberOfParcels();
	}
	
	public List<Object[]> totalParcelByRoute(){
		return parcelRepository.totalParcelsByRoute();
	        
	}
}
