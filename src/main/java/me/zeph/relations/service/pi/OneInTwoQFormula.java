package me.zeph.relations.service.pi;

import me.zeph.relations.model.OneParentReqParam;

public class OneInTwoQFormula extends Formula {
	@Override
	public double calculate(double c1Value, double c2Value, double af1Value, double af2Value,
	                        OneParentReqParam reqParam) {
		return (isPQQQ(reqParam) || isQQQR(reqParam)) ? (1 / (af1Value * 2)) : 0;
	}

	private boolean isQQQR(OneParentReqParam reqParam) {
		return c1EqualC2(reqParam) && c2EqualAf1(reqParam) && !af1EqualAf2(reqParam);
	}

	private boolean isPQQQ(OneParentReqParam reqParam) {
		return !c1EqualC2(reqParam) && c2EqualAf1(reqParam) && af1EqualAf2(reqParam);
	}
}
