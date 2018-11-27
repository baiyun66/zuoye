package net.mooctest;
public class Example{
    int a;
    int b;
    int ans;

    public Example(int m, int n){
		a = m;
        b = n;
    }
    
    public int Function_A(int x,int y){
       if(x < 6 && y > 0) {
    	   ans = x + a;  
       }
       else{
    	   ans = x - a;
       }
       
       return ans; 
    }

    public int Function_B(int x){
       if(x < 6)
          ans =  x * a;
       else
          ans =  x / b;
      
       return ans;
    }
    
}