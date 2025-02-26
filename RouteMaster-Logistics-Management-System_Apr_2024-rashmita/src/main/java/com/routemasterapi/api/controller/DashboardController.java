package com.routemasterapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.routemasterapi.api.service.CustomerService;
import com.routemasterapi.api.service.ParcelService;
import com.routemasterapi.api.service.TrackParcelService;
  
@RestController
@CrossOrigin
public class DashboardController {
	
	@Autowired
	private ParcelService parcelService;	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TrackParcelService trackParcelService;
	
	@RequestMapping(value = "/totalParcels", method = RequestMethod.GET)
	public ResponseEntity<?> totalParcels() throws Exception {
		return ResponseEntity.ok(parcelService.totalNoOfParcelsSent());
	}
	
	@RequestMapping(value = "/totalCustomers", method = RequestMethod.GET)
	public ResponseEntity<?> totalCustomers() throws Exception {
		return ResponseEntity.ok(customerService.totalNoOfCustomers());
	}

	@RequestMapping(value = "/totalPayments", method = RequestMethod.GET)
	public ResponseEntity<?> totalCompletePaymentParcels() throws Exception {
		return ResponseEntity.ok(trackParcelService.listallcompletepaymentparcels());
	}
	@RequestMapping(value = "/totalParcelsByRoute", method = RequestMethod.GET)
	public ResponseEntity<?> totalParcelsByRoute() throws Exception {
		return ResponseEntity.ok(parcelService.totalParcelByRoute());
	}
	
}
