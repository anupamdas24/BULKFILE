class testCheck
{
	// static variable
	static int a = 10;
	static int b;
	static int c=a+b;
	private static void Syso() {
		System.out.printf("from syso ::",c);

	}
	
	// static block
	static {
		System.out.println("Static block initialized.");
		b = a * 4;
	}

	public static void main(String[] args)
	{
	Syso();
	System.out.println("from main");
	System.out.println("Value of a : "+a);
	System.out.println("Value of b : "+b);
	}
}
