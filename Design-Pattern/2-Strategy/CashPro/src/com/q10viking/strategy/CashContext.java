package com.q10viking.strategy;

public class CashContext {
	//声明一个CashSuper
	private CashSuper cs;
	
	public CashContext(CashSuper cashsuper) {
		cs = cashsuper;
	}
	public double GetResult(double money) {
		return cs.acceptCash(money);
	}
	//策略模式与工厂模式的结合
	public CashContext(String type) {
		switch(type) {
			case "正常收费":
				cs = new CashNormal();
				break;
			case "满300返100":
				cs = new CashReturn("300","100");
				break;
			case "打8折":
				cs = new CashRebate("0.8");
				break;
			default:
		}
	}
}
