import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.HashMap;
import java.time.Duration;
import java.time.Instant;

public class Main {
	
	public static void afiseazaVecini(HashMap<String, ArrayList<String>> vecini)
	{
		for(String s : vecini.keySet())
		{
			System.out.print("Cuvantul " + s + " are vecinii: ");
			for(String string :  vecini.get(s))
			{
				System.out.print(string + " ");
			}
			System.out.println("");
			System.out.println("");
		}
	}
	
	public static void afiseazaMatrice(boolean[][] matrice,int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrice[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("");
	}
	
	
	public static void afiseazaCuvinte(ArrayList<String> words)
	{
		for(int i=0;i<words.size();i++)
		{
			System.out.println(words.get(i));
		}
	}
	
	

	public static void main(String[] args) {
		
		/*Scanner ss = new Scanner(System.in);
		String alphabet = ss.next();
		Integer p = ss.nextInt();
		Integer n = ss.nextInt();*/
		Integer p = 0;
		Integer n = 0;
		String alphabet = "";
		if(args.length<3)
		{
			System.out.println("NU-I DESTUL (MINIM 3)");
			System.exit(-1);
		}
		n = Integer.valueOf(args[0]);
		p = Integer.valueOf(args[1]);
		for(int i=2;i<args.length;i++)
		{
			if(args[i].length()>1)
			{
				System.out.println("TB LITERA NU CUVANT");
				System.exit(-1);
			}
			alphabet = alphabet + args[i];
		}

		/*String alphabet = "abcdefghijklmn";
		Integer m = alphabet.length();
		Integer p = 3;
		Integer n = 30000;*/

		ArrayList<String> words = new ArrayList<>();
		
		long start1 = System.nanoTime();

		for (int i = 0; i < n; i++) 
		{
			String aux = "";
			for (int j = 0; j < p; j++) 
			{
				aux = aux + alphabet.charAt(((int) (Math.random() * (alphabet.length()))));
			}
			words.add(aux);
		}

		afiseazaCuvinte(words);
		
		boolean[][] matrice = new boolean[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				matrice[i][j]=false;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j)
				{
					for(int x=0;x<p;x++)
					{
						if(words.get(j).contains(String.valueOf(words.get(i).charAt(x))))
						{
							matrice[i][j]=true;
						}
					}
				}
			}
		}
		
		//afiseazaMatrice(matrice,n);
		
		HashMap<String, ArrayList<String>> vecini = new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<n;i++)
		{
			ArrayList<String> neighbours = new ArrayList<>();
			for(int j=0;j<n;j++)
			{
				if(matrice[i][j]==true)
				{
					neighbours.add(words.get(j));
				}
			}
			
			vecini.put(words.get(i),neighbours);
		}
		
		afiseazaVecini(vecini);
		
	    
	    long end1 = System.nanoTime();
	    System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
	    System.out.println("ok!");
		
		
		
	}

}
