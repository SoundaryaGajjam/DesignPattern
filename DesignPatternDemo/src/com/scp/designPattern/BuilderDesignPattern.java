package com.scp.designPattern;

import com.scp.designPattern.StudentInfo.StudentBuilder;

public class BuilderDesignPattern {
	public static void main(String[] args) {
		System.out.println("Student 1 info : ");
		StudentInfo obj1=new StudentBuilder("WadaPav", "reading").setCoding("Java Programming").setPlaying("Hockey").setEntertainment("TV").build();
		System.out.println(obj1);
		System.out.println("Student 2 info : ");
		StudentInfo obj2=new StudentBuilder("Chicken","writing").setPlaying("Chess").build();
		System.out.println(obj2);
	}
}
class StudentInfo{
	//manditory
	String eating;
	String studying;
	
	//optional
	String playing;
	String coding;
	String entertainment;
	
	public StudentInfo(StudentBuilder studentBuilder) {
		this.eating=studentBuilder.eating;
		this.studying=studentBuilder.studying;
		this.playing=studentBuilder.playing;
		this.coding=studentBuilder.coding;
		this.entertainment=studentBuilder.entertainment;
	}
	
	
	
	@Override
	public String toString() {
		return "\nStudentInfo [eating=" + eating + ", studying=" + studying + ", playing=" + playing + ", coding="
				+ coding + ", entertainment=" + entertainment + "]\n";
	}



	static public class StudentBuilder{
		//manditory
		String eating;
		String studying;
		
		//optional
		String playing;
		String coding;
		String entertainment;
		public StudentBuilder(String eating, String studying) {
			super();
			this.eating = eating;
			this.studying = studying;
		}
		
		public StudentBuilder setPlaying(String playing) {
			this.playing = playing;
			return this;
		}
		public StudentBuilder setCoding(String coding) {
			this.coding = coding;
			return this;
		}
		public StudentBuilder setEntertainment(String entertainment) {
			this.entertainment = entertainment;
			return this;
		}
		
		public StudentInfo build(){
			return new StudentInfo(this);
		}
		
	}
}
