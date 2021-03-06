package com.codependent.rx.samplescada.machine;


public class Signal {

	public enum Type {
		MACHINE_STARTED,
		MACHINE_STOPPED,
		MACHINE_OPERATING,
		MACHINE_PAUSED,	
		JARDEPOSIT_CAPACITY,
		JARDEPOSIT_DROPPED_JAR,
		JARDEPOSIT_EMPTY,
		JAR_IN_JARMACHINE, 
		JAR_IN_JARMACHINE_FILLING_INFO,
		JAR_IN_BELT_POSITION,
		JAR_IN_BELT_END,
		JARMACHINE_JAR_FILLED,
		TRANSLATIONROBOT_PICKINGUP_JAR,
		TRANSLATIONROBOT_TRANSLATING,
		TRANSLATIONROBOT_TRANSLATED,
		TRANSLATIONROBOT_RETURNING,
		TRANSLATIONROBOT_RETURNED};
	
	private Type type;
	private String info;
	
	public Signal(Type type){
		this.type = type;
	}
	
	public Signal(Type type, String info){
		this.type = type;
		this.info = info;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Signal [type=" + type + ", info=" + info + "]";
	}
	
}
