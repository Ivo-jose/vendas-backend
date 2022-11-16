package com.ivogoncalves.course.domain.enums;

public enum OrderStatus {

	WAIT_PAYMENT(0,"ROLE_WAIT_PAYMENT"), PAID(1,"ROLE_PAID"), SHIPPED(2,"ROLE_SHIPPED"), 
	DELIVERED(3,"ROLE_DELIVERED"), CANCELED(4,"ROLE_CANCELED");
	
	private Integer cod;
	private String desc;
	
	private OrderStatus(Integer cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static OrderStatus toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(OrderStatus x : OrderStatus.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid order status code!");
	}
	
}
