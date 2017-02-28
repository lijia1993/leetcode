public class Solution504 {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            isNegative = true;
            num = 0 - num;
        }
        while(num!=0){
            sb.append(num%7);
            num/=7;
        }
        sb = sb.reverse();
        String result = (isNegative)?"-":"";
        return  result + sb.toString();
    }

    public void test(){
        int num = -7;
        System.out.println(convertToBase7(num));
    }
}
