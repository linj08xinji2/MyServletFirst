package suggest;

public class Client {
	{
		System.out.println("cccc");
	}

	public static void main(String[] args) {
		Client c=new Client();
		Client c1=new Client("dd");
	}

	
	
	public Client() {
		System.out.println("aaa");
	}

	public Client(String name) {
		System.out.println("bbbbb");
	}

}
