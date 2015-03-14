package me.zeph.relations.model;

import com.wordnik.swagger.annotations.ApiModel;

@ApiModel
public class CPIValue {
	private double value;


	public CPIValue() {
	}

	public CPIValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}