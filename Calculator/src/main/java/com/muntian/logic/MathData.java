package com.muntian.logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MathData implements Observable {
	
	private List<Observer> observers;
	
    private Double firstOperand;
    private Double secondOperand;
    private String sign;
    private boolean isOnFlyMode;
    private boolean isPressedBtnCalculate;


	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(Map params) {
		if (!isValid()) return;
		for(Observer observer : observers) {
			observer.update(params);
		}
	}
	

	public List<Observer> getObservers() {
		return observers;
	}

	
	public double getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
		notifyObservers(getParams());
	}

	public double getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
		notifyObservers(getParams());
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
		notifyObservers(getParams());
	}

	public MathData() {
		observers = new LinkedList<>();
	}
	
	public boolean isOnFlyMode() {
		return isOnFlyMode;
	}

	public void setOnFlyMode(boolean isOnFlyMode) {
		this.isOnFlyMode = isOnFlyMode;
		notifyObservers(getParams());
	}
	
	public void setPressedBtnCalculate(boolean isPressedBtnCalculate) {
		this.isPressedBtnCalculate = isPressedBtnCalculate;
		notifyObservers(getParams());
	}
	
	private Map getParams() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstOperand", firstOperand);
		map.put("secondOperand", secondOperand);
		map.put("sign", sign);
		map.put("onFlyMode", isOnFlyMode);
		return map;
	}
	
	private boolean isValid() {
		if (firstOperand != null && secondOperand != null && sign != null) { 
			return true;
		} else return false;
	}

}
