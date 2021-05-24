package chatserver;

import java.util.Random;

public class entry_decry {
entry_decry(String id){
	id=id.replace(".", ":");
	String[] a=id.split(":");
	String re="",re1="";
	int[] num= {0,1,2,3,4,5,6,7,8,9};
	String[] alp= {"a","r","t","x","q","w","s","p","k","j"};
	int f=0;
	for (int i=0;i<10;i++) {
		if (String.valueOf(num[i]).compareTo(id.substring(0,1))==0)
			f=1;
	}
	Random rand=new Random();
	if (f==1) {
		int ch =9; //rand.nextInt(num.length);
		for (int i=0;i<a.length;i++) {
			
			while (a[i].length()<3)
				a[i]="0"+a[i];
			int e=0;
			for (int j=0;j<3;j++) {
				int x=Integer.parseInt(String.valueOf(a[i].charAt(j)));
				x+=ch+j;
				if (x>9)
					x-=10;
				e=10*e+x;
			}
			re+=String.valueOf(e)+".";
		}
		System.out.println(re);
		re+=String.valueOf(ch);
		for (int i=0;i<re.length();i++) {
		if(re.charAt(i)!='.') {
			String c1=String.valueOf(re.charAt(i));
			int c=Integer.parseInt(c1);
			re1+=alp[c];
			
		}
		else
			re1+=".";
		}
		System.out.println(re1);
	}
}
public static void main(String ar[]) {
	new entry_decry("192.168.43.16");
}
}
