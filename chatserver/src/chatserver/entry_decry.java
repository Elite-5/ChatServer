package chatserver;

import java.util.Random;

import javax.swing.JOptionPane;

public class entry_decry {
	private String re="",re1="";
entry_decry(String id){
	try {
	id=id.replace(".", ":");
	String[] a=id.split(":");
	int[] num= {0,1,2,3,4,5,6,7,8,9};
	String[] alp= {"a","r","t","x","q","w","s","p","k","j"};
	int f=0;
	String e="";
	for (int i=0;i<10;i++) {
		if (String.valueOf(num[i]).compareTo(id.substring(0,1))==0)
			f=1;
	}
	Random rand=new Random();
	if (f==1) {
		int ch =rand.nextInt(num.length);
		for (int i=0;i<a.length;i++) {
			
			while (a[i].length()<3)
				a[i]="0"+a[i];
			e="";
			for (int j=0;j<3;j++) {
				int x=Integer.parseInt(String.valueOf(a[i].charAt(j)));
				x+=ch+j;
				if (x>9)
					x-=10;
				e+=String.valueOf(x);
				
			}
			re+=e+".";
		}
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
	}
	else {
		for (int i=0;i<id.length();i++) {
			int c=0;
			if(id.charAt(i)!=':') {
				String c1=String.valueOf(id.charAt(i));
				for (int j=0;j<alp.length;j++) {
					if (alp[j].compareTo(c1)==0)
						c=j;
				}
				re+=num[c];
			}
			else
				re+=":";
			}
		String [] re2=re.split(":");
		int ch=Integer.parseInt(re2[re2.length-1]);
		for (int i=0;i<re2.length-1;i++) {
			e="";
		for (int j=0;j<3;j++) {
			int x=Integer.parseInt(String.valueOf(re2[i].charAt(j)));
			
			x=x-ch-j;
			
			if (x<0)
				x+=10;
			e+=String.valueOf(x);	
		}
		int z=0;
		for (int j=0;j<e.length();j++) {
			z+=1;
			if (e.charAt(j)!='0')
				break;}
		re1+=e.substring(z-1,e.length())+".";
		
	}
		re1=re1.substring(0,re1.length()-1);
	}}catch(Exception e) {JOptionPane.showMessageDialog(null,"Invalid Id/Connection to network failed.");
	re1="incorrect";
	e.printStackTrace();}
}
public String convert() {
	
	return re1;
}
}
