package com.q10viking.strategy;
//打折收费
public class CashRebate extends CashSuper {
	private double moneyRebate = 1d;
	//初始化时，必须输入折扣率，如八折，就是0.8
	public CashRebate(String moneyRebate) {
		this.moneyRebate = Double.parseDouble(moneyRebate);
	}
	@Override
	public double acceptCash(double money) {
		return money*moneyRebate;
	}
}
