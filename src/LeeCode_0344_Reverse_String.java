import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class LeeCode_0344_Reverse_String {
	public static void reverString(String str) {
		String[] strArr=str.split("");
		ArrayList<String> list_Str=new ArrayList<String>(Arrays.asList(strArr));
		//Swap only support list
		for (int i=0;i<Math.ceil(list_Str.size()/2);i++) {
			Collections.swap(list_Str,i,list_Str.size()-i-1);
			System.out.println("Head "+list_Str.get(i));
			System.out.println("tail "+list_Str.get(list_Str.size()-i-1));
		}
		System.out.println(list_Str);
//		list_Str.forEach((n) -> System.out.println(n));
		}


	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("keyin string");
//		String[] str=new String[] {scanner.nextLine()};
		String str=scanner.nextLine();

    	reverString(str);
		
		scanner.close();
		
		// FileReader- read the contents of a file as a stream of characters. One by one
		//         	   read() reaturns an int value which contains the byte value
		//             when read() returns -1, there is no more data to read
	
		//		try {
////			FileReader reader = new FileReader("art.txt");
//		}
//		catch(FileNotFoundException e){
//			
//		}
	}

}
