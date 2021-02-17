package util;

import java.util.Scanner;

public class ScanUtil {
	
	private static Scanner s = new Scanner(System.in);
	
	//유틸리티 성향의 메서드인 경우 static를 붙인다. (객체생성을 하지않고 사용하기위해)
	public static String nextLine(){
		return s.nextLine();
	}
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
	}
	
}
