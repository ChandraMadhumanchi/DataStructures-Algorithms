package codingcrackingInterview;

public class CountDecoding {

	public static void main(String[] args) {

		System.out.println("" +  decode("123"));
		
	}

	public static int decode(String message){
		
		int msglen = message.length();
		
		if(msglen == 0 || msglen == 1)
			return 1;
		
		int count =0;
		
		if(message.charAt(msglen - 1) > '0') // last digit
			count = decode(message.substring(0,msglen - 1)); // trimmed message by decreasinh lenght ny 1
		
		if ((message.charAt(msglen - 2) < '2') || (message.charAt(msglen - 2) == '2' && message.charAt(msglen - 1) < '7')) 
			count += decode(message.substring(0,msglen - 2)); // trimmed message by decreasinh lenght ny 2
		
		return count;
	}
}
