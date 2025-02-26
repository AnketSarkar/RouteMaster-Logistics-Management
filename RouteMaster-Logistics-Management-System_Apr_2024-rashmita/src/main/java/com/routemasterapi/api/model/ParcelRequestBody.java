package com.routemasterapi.api.model;

import java.util.List;

public class ParcelRequestBody { 
		 
	private int parcelId;

	private String parcelType;

	private String parcelName;
	
	private int parcelPrice;

	private String destinationAddress;

	private String destinationPincode;

	private String senderName;

	private String receiverName;

	private String consignmentNumber;

	private String imageUrl;

	private int customerId;

	private int routeId;
	
	private List<Integer> trackParcelId;
	
	private String addedOn;

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public String getParcelName() {
		return parcelName;
	}

	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}

	public int getParcelPrice() {
		return parcelPrice;
	}

	public void setParcelPrice(int parcelPrice) {
		this.parcelPrice = parcelPrice;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationPincode() {
		return destinationPincode;
	}

	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getConsignmentNumber() {
		return consignmentNumber;
	}

	public void setConsignmentNumber(String consignmentNumber) {
		this.consignmentNumber = consignmentNumber;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public List<Integer> getTrackParcelId() {
		return trackParcelId;
	}

	public void setTrackParcelId(List<Integer> trackParcelId) {
		this.trackParcelId = trackParcelId;
	}


		 
	}
