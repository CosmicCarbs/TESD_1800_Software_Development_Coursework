public class Exercise10_3 {
    public static void main(String[] ags){
        MyInteger integer = new MyInteger(10);
        char[] number = {'2','0','5'};
        System.out.println(integer.isEven());
        System.out.println(integer.isOdd());
        System.out.println(integer.isPrime());
        System.out.println(MyInteger.isEven(13));
        System.out.println(MyInteger.isOdd(13));
        System.out.println(MyInteger.isPrime(13));
        System.out.println(integer.isEven(new MyInteger(23)));
        System.out.println(integer.isOdd(new MyInteger(16)));
        System.out.println(integer.isPrime(new MyInteger(11)));
        System.out.println(integer.equals(17));
        System.out.println(integer.equals(new MyInteger(10)));
        System.out.println(integer.parseInt(number));
        System.out.println(integer.parseInt("125"));
    }
}
class MyInteger{
    int value;

    MyInteger(int newValue){
        value = newValue;
    }
    boolean isEven(){
        if(value % 2 == 0)
            return true;
        return false;
    }
    boolean isOdd(){
        if(value % 2 == 1)
            return true;
        return false;
    }
    boolean isPrime(){
        for(int i = 2; i < value; i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
    static boolean isEven(int value){
        if(value % 2 == 0)
            return true;
        return false;
    }
    static boolean isOdd(int value){
        if(value % 2 == 1)
            return true;
        return false;
    }
    static boolean isPrime(int value){
        for(int i = 2; i < value; i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
    static boolean isEven(MyInteger input){
        if(input.value % 2 == 0)
            return true;
        return false;
    }
    static boolean isOdd(MyInteger input){
        if(input.value % 2 == 1)
            return true;
        return false;
    }
    static boolean isPrime(MyInteger input){
        for(int i = 2; i < input.value; i++){
            if(input.value % i == 0)
                return false;
        }
        return true;
    }
    boolean equals(int input){
        if(value == input)
            return true;
        return false;
    }
    boolean equals(MyInteger input){
        if(input.value == value)
            return true;
        return false;
    }
    static int parseInt(char[] number){
        String value = new String(number);
            return Integer.parseInt(value);
    }
    static int parseInt(String number){
        return Integer.parseInt(number);
    }
}