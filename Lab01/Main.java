import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		
		//1.
        System.out.println("Hello World!"); 
        
        //2.
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        
        //3.
        int n = (int)(Math.random()*1000000);
        System.out.println(n);
        
        //4.
        n=n*3;
        String binar = "10101";
        n=n+Integer.parseInt(binar,2);
        String hex = "FF";
        n=n+Integer.parseInt(hex,16);
        n=n*6;
        System.out.println(n);
        
        //5.
        while(n/10>0)
        {
        	int sum = 0;
        	while(n!=0)
        	{
        		sum = sum + n%10;
        		n=n/10;
        	}
        	n=sum;
        }
        System.out.println(n);
        
        //6.
        System.out.print("Willy-nilly, this semester I will learn ");
        for(String language : languages)
        {
        	System.out.print(language + " ");
        }
    }
}
