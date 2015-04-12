package org.xinjg.leetcode;

/*
 * Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, 
 starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
 and interprets them as a numerical value.
 The string can contain additional characters after those that form the integral number, which are ignored and have
 no effect on the behavior of this function.
 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists 
 because either str is empty or it contains only whitespace characters, no conversion is performed.
 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of 
 representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class String2Integer {
	public int atoi(String str) {
		str =str.trim();
		int len =str.length();
		if (len<1) {
			return 0;
		}
		boolean begin = false;
		int beginIndex=0;
		int endIndex =1;
		for (int i = 0; i < str.length(); i++) {
			if (!begin&&(str.charAt(i)=='+'|| str.charAt(i)=='-'||(str.charAt(i)>='1'&&str.charAt(i)<='9') )) {
				begin = true;
				beginIndex=i;
			}else if (begin&&(str.charAt(i)<'0'||str.charAt(i)>'9')) {
				endIndex=i;
				break;
			}else if (!begin&&(str.charAt(i)<'0'||str.charAt(i)>'9')) {
				return 0;
			}else {
				endIndex++;
			}
		}
		str =str.substring(beginIndex, endIndex);
		len = endIndex-beginIndex;
		int val=0;
		int val1=0;
		int power =0;
		while(len>0 ){
			char c= str.charAt(--len);
			if(c>='0'&& c<='9'){
				val1 = val + valueOf(c)*(int) Math.pow(10, power++);
				if (val1<val) {//out of range
					return (str.charAt(0)=='-'?  -2147483648:2147483647);
				}else
					val=val1;
			}else if (c=='+'||c=='-') {//·ûºÅÎ»
				return c=='-' ? -val:val;
			}
		}
		return val;
	}
	private static int valueOf(char c){
		int value;
		switch (c) {
		case '0':value=0;break;		
		case '1':value=1;break;
		case '2':value=2;break;
		case '3':value=3;break;
		case '4':value=4;break;
		case '5':value=5;break;
		case '6':value=6;break;
		case '7':value=7;break;
		case '8':value=8;break;
		case '9':value=9;break;
		default:value=0;
			break;
		}
		return value;
	}
	
	public static void main(String[] args) {
		String2Integer string2Integer = new String2Integer();
		System.out.println(string2Integer.atoi("   --123"));
	}
}
