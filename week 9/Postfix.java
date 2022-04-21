import java.util.Scanner;
public class Postfix {
    int n;
    int top;
    char[]stack;
    
    public  Postfix(int total){
        n=total;
        top =-1;
        stack =new char[n];
        push('(');
    }
    public void push(char c){
       top++; 
       stack[top]=c;
    }
    public char pop(){
        char item =stack[top];
        top--;
        return item;
    }
    public boolean IsOperand(char c){
        if((c>= 'A' && c <= 'Z') || (c >= 'a'&& c <= 'z') || (c >= '0' && c <= '9') || c == ' ' || c == '.'){ 
            return true;
        }else{
            return false;
        }
    }
    public boolean IsOperator(char c){
        if( c == '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+'){
            return true;
        }else{
            return false;
        }
    }
    public int derajat(char c){
        switch (c){
            case '^':
                return 3;
            case '%':
                return 2;
            case'/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            default:
                return 0;
        }
    }
    public String konversi(String b){
        String a =" ";
        char c;
        for(int i = 0; i < n; i++){
            c =b.charAt(i);
            if(IsOperand(c)){
                a = a+c;
            }
            if (c == '('){
                push(c);
            }
            if ( c == ')'){
                while( stack[top] != '('){
                    a = a+ pop();
                }
                pop();
            }
            if (IsOperator(c)){
                while (derajat(stack[top]) >=  derajat(c)){
                    a = a+pop();
                }
                push(c);
            }
        }
        return a;
    }
}
class PostfixMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a, b;
        System.out.println("Masukkan ekspresi matematika (infix) : ");
        b = sc.nextLine();
        b = b.trim();
        b = b + ")";
        
        int total = b.length();
        Postfix post = new Postfix(total);
        a = post.konversi(b);
        System.out.println("Postfix : "+ a);
    }
}