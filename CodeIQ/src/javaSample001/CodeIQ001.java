package javaSample001;

import java.math.BigDecimal;
class CodeIQ{
public static void main(String[] args){
    BigDecimal pointOne = new BigDecimal("0.1");
    BigDecimal sum = new BigDecimal(0);

      for(int i=0;i<10;i++){
      sum = sum.add(pointOne);
    }
    System.out.println("ans:"+ sum);
    }
}