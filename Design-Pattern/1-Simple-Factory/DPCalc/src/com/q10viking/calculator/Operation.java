package com.q10viking.calculator;

public abstract class Operation {
	protected double _numberA=0;
	protected double _numberB=0;
	public void setA(double A) {
		_numberA = A;
	}
	public void setB(double B) {
		_numberB = B;
	}
	public abstract double GetResult();
}


