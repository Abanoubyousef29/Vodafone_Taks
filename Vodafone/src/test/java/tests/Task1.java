package tests;

import java.util.Scanner;

import org.testng.annotations.Test;

import pages.CheckPalindrome;

public class Task1 extends CheckPalindrome {
	
	@Test
	public static void Palindrome ()
	{
		Scanner sc= new Scanner(System.in);
		Boolean statusResult;
		
		
		String CheckecString = "dad";
		statusResult = Checkpalindrome(CheckecString);
		System.out.println("the statues of "+CheckecString +" is "+statusResult);
		
		
		System.out.println("Enter the string you want to check: ");
		String str= sc.nextLine(); 
		statusResult = Checkpalindrome(str);
		System.out.println("the statues of "+str +" is "+statusResult);
		
		sc.close();
		
	}

}
