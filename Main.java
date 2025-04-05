import java.util.*;
import java.math.*;


public class Main {
	public static void main(String args[]){
		TimeClass time = new TimeClass();
		time.setTime(40, 30, 2);
		System.out.println("Seconds: " + time.seconds + " Minutes: "+time.minutes+ " Hours: "+time.hours);
		time.subtractSeconds(3600);
		System.out.println("Seconds: " + time.seconds + " Minutes: "+time.minutes+ " Hours: "+time.hours);
	}
}
class TimeClass{
	public int seconds, minutes, hours;
	void setTime(int s, int m, int h){
		seconds = s%60;
		minutes = m%60;
		hours = h%24;
	}

	void addSeconds(int s){
		int mins = (s+seconds)/60;	
		int hs = (mins+minutes)/60;
		seconds = (seconds+s)%60; 
		minutes = (mins+minutes)%60;  
		hours = (hours+hs)%24;
	}

	void addMinutes(int m){
		int hs = (m+minutes)/60;
		minutes = (m+minutes)%60;  
		hours = (hours+hs)%24;
	}

	void subtractSeconds(int s){
		int mins = (Math.abs(s-seconds)/60);
		if(s > seconds && ((Math.abs(s-seconds))%60 != 0)){
			mins++;
		}
		int hs = (Math.abs(mins-minutes)/60);
		if(mins > minutes && ((Math.abs(mins-minutes))%60 != 0)){
			hs++;
		}
		System.out.println(mins + " " + hs);
		seconds = (Math.abs(s-seconds)%60);
		if(Math.abs(s-seconds)%60 > 0){
			seconds = 60-seconds;
		}
		minutes = (Math.abs(mins-minutes)%60);
		hours = (Math.abs(hs-hours)%24);
	}


}



/*

Time Calculation: Create a class called Time that represents 
a time of day(hours, minutes, and seconds). Implement methods to 
set the time, add a given number of seconds to the current time, 
subtract a given number of seconds to current time, and display the 
time in the format "HH:MM:SS".  

Note: it should be reset to 00:00:00 after 23:59:59.


		int mins = (s+seconds)%60;	
		int hs = (mins+minutes)/60;
		seconds = (seconds+s)%60; 
		minutes = (mins+minutes)%60;  
		hours = (hours+hs)%24;

 seconds = 40, s = 120, minutes = 23, hours = 1;

hs = ((s)/3600)+((s%3600) != 0);
mins = (s/60)+((s%60)!=0);
seconds = 59-(abs(s-seconds)%60);
minutes = 59-(abs(mins-minutes)%60);
hours = 23-(abs(hs-hours)%24);
*/

