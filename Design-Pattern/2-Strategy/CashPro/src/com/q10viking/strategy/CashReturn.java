package com.q10viking.strategy;
//返利收费
public class CashReturn extends CashSuper {

	private double moneyCondition = 0.0d;
	private double moneyReturn  = 0.0d;
	/*
	 * 初始化时，必须要输入返利条件和返利值
	 */
	public CashReturn(String moneyCondition,String moneyReturn) {
		this.moneyCondition = Double.parseDouble(moneyCondition);
		this.moneyReturn = Double.parseDouble(moneyReturn);
		
	}
	@Override
	public double acceptCash(double money) {
		double result = money;
		if(money>=moneyCondition)
			result = money-Math.floor(money/moneyCondition)*moneyReturn;
		return result;
	}

}
