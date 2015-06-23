public class primeNumber {
	public static void main(String[] args) {
		if(args.length == 0) return;
		System.out.println("Testing if "+args[0]+" is prime.");
		System.out.println(actualTest(Integer.parseInt(args[0])));
	}
	public static String actualTest(int p) {
		if(p<=1) return "Not prime.";
		if(p<4) return "Prime.";
		if(p%2 == 0) return "Not prime.";
		int maxTest = (int)Math.sqrt((double)p);
		System.out.println(maxTest);
		for(int i = 3; i<= maxTest; i+=2)
			if(p%i == 0) return "Not prime.";
		return "Prime.";
	}
}
