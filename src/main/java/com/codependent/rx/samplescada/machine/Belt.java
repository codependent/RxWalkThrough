package com.codependent.rx.samplescada.machine;

import java.util.List;

import com.codependent.rx.samplescada.sensor.PositionSensor;
import com.codependent.rx.samplescada.sensor.Signal;

import rx.Observer;


public abstract class Belt extends Machine implements Observer<Signal>{
	
	protected double lenght;
	protected double speed;
	protected boolean emptyBelt = true;
	protected List<PositionSensor> positionSensors;
	
	public Belt(double length, double speed, List<PositionSensor> positionSensors){
		this.lenght = length;
		this.speed = speed;
		this.positionSensors = positionSensors;
	}
	
	public abstract void addJar();

	public boolean isEmptyBelt() {
		return emptyBelt;
	}
	
	public double getLenght() {
		return lenght;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void doOnStart(){
		doOnBeltStart();
	}
	
	public void doOnStop(){
		doOnBeltStop();
	}
	
	public abstract void doOnBeltStart();
	public abstract void doOnBeltStop();
	
	@Override
	public void onNext(Signal s) {
		if(s.getType() == Signal.Type.JAR_IN_JARMACHINE ||
		   s.getType() == Signal.Type.JAR_IN_BELT_END){
			stop();
		}
	}
	
	@Override
	public void onCompleted() {
		logger.debug("Completed");
	}
	
	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}
	
}
