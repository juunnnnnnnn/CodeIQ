package straightLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[]args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String buf = null;
		try {
			buf = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		int number = Integer.parseInt(buf);

		//int number=10;//標準入力より取得予定
		int lattice = number * number;//格子の数
		int finalAnswer=0;


		//x,y座標を生成
		ArrayList<Tuple2<Integer, Integer>> ar= new ArrayList<Tuple2<Integer, Integer>>();
		for(int ii=0; ii<number; ii++){
			for (int j = 0; j<number;j++){
				//@param
				Tuple2<Integer, Integer> tuple2=Tuple.of(ii, j);
				ar.add(tuple2);

				//試し　あとで消す
				/*	System.out.println("試しに出力　x:"+tuple2.car);
					System.out.println("試しに出力　y:"+tuple2.cdr.car);*/

			}
		}
		/*//試し　あとで消す
		System.out.println("\r\n");
		System.out.println("arを出力");*/

	/*	for(int i4 = 0;i4<lattice;i4++){
			System.out.println("x:"+ar.get(i4).car);
			System.out.println("y:"+ar.get(i4).cdr.car);
		}*/


		//組み合わせを計算
		//Combination combination = new Combination();
		Integer intArray[]= new Integer[lattice];

		Set<Integer> src = new HashSet<Integer>() {};

		for(Integer h= 0; h<intArray.length; h++){
			intArray[h]=h;
			src.add(h);

/*			//あとで消す
			System.out.println("intArrayの値"+intArray[h]);
*/		}

/*		//一番候補
    System.out.println(combination2(src, 2)); // 上記集合のなかから2つを取りだした集合を全て列挙する
*/
    //組み合わせごとに処理を実行
    for(Set<Integer> tmp : combination2(src, 2)){
    	int countOfQuestion = 0;
       // System.out.println(tmp);
/*        System.out.println("\r\ntmp.toString "+tmp.toString());
*/        String result1=tmp.toString().replaceAll("\\[", "");
        result1=result1.replaceAll("\\]", "");

        /*System.out.println("result1:"+result1);
*/
        Pattern p = Pattern.compile("[,\\s]+");
        String[] result2=p.split(result1);
        for(int i3 = 0; i3<result2.length;i3++){

        /*	System.out.println("正規表現で分割した値："+Integer.parseInt(result2[i3]));//result2[0]が、1つめの座標。result2[1]が、2つめの座標。
        */
        }

        	//座標毎に処理を実行する。
        	for(int i5=0;i5<lattice;i5++){

            	/*System.out.println("linearEquation:"+
        		linearEquation(
            			ar.get(Integer.parseInt(result2[0])).car, ar.get(Integer.parseInt(result2[0])).cdr.car,
            			ar.get(Integer.parseInt(result2[1])).car, ar.get(Integer.parseInt(result2[1])).cdr.car,
            			ar.get(i5).car, ar.get(i5).cdr.car)
        		);
            	*/

            	countOfQuestion =
            			countOfQuestion
            			+linearEquation(
                    			ar.get(Integer.parseInt(result2[0])).car, ar.get(Integer.parseInt(result2[0])).cdr.car,
                    			ar.get(Integer.parseInt(result2[1])).car, ar.get(Integer.parseInt(result2[1])).cdr.car,
                    			ar.get(i5).car, ar.get(i5).cdr.car);
            		//もしlinearEquationの返り血が３つ以上の場合、ノーカウント。２の場合、カウント。
            		//finalAnswer++;
            	}
        	if( countOfQuestion==2){
        		finalAnswer++;
        		}
        	}
    System.out.println(finalAnswer);
    }
	//linearEquation(ar.get(result2[0]).car, lattice, lattice, lattice, lattice, lattice) ;

//main終わり


	//配列をカンマ区切りの文字列に
	public	Integer[] combining(Integer lat){
		System.out.println("\r\n配列をカンマ区切りの文字列に実施");
		Integer[] ary = new Integer[lat];

		for(int d =0; d<lat;d++){
			ary[d]=d;
		}
		return ary;
	}



	//格子の中に、何個の直線があるか調べる関数

	private static int linearEquation(int x1,int y1,int x2,int y2, int x,int y){
		int PointOfIntersection = 0;
		if((x2-x1)*(y-y1)==(y2-y1)*(x-x1)){
			PointOfIntersection++;
			}
		return PointOfIntersection;
		}

	//x,y座標の実現のため、タプルを実装
	  public static class Pair<A, B> {
	        public final A car;
	        public final B cdr;
	        public Pair(A car_, B cdr_) {car = car_; cdr = cdr_;}

	        private static boolean eq(Object o1, Object o2) {return o1 == null ? o2 == null : o1.equals(o2);}
	        private static int hc(Object o) {return o == null ? 0 : o.hashCode();}

	        @Override public boolean equals(Object o) {
	            if (! (o instanceof Pair)) return false;
	            Pair<?, ?> rhs = (Pair<?, ?>) o;
	            return eq(car, rhs.car) && eq(cdr, rhs.cdr);
	        }
	        @Override public int hashCode() {return hc(car) ^ hc(cdr);}
	        @Override public String toString() {return "[" + (car != null ? car.toString() : "null") + " : " + (cdr != null ? cdr.toString() : "null") + "]";}
	    }

	    public static class Tuple1<A> extends Pair<A, Object> {
	        public Tuple1(A a) {super(a, null);}
	    }

	    public static class Tuple2<A, B> extends Pair<A, Tuple1<B>> {
	        public Tuple2(A a, B b) {super(a, new Tuple1<>(b));}
	    }
	    public static class Tuple {
	        public static <A> Tuple1<A> of(A a) {return new Tuple1<A>(a);}
	        public static <A, B> Tuple2<A, B> of(A a, B b) {return new Tuple2<A, B>(a, b);}
	    }

	    //組み合わせの計算
	    private enum Operation {add, remove};
	    private static<T> Set<T> apply(Set<T> src, Operation operation, T item) {
	        Set<T> result = new HashSet<T>(src);
	        if (Operation.add == operation) result.add(item);
	        if (Operation.remove == operation) result.remove(item);
	        return result;
	    }

	    private static<T> Set<Set<T>> _combination(Set<T> selected, int depth, Set<T> pool) {
	        if (depth == 0) return apply(new HashSet<>(), Operation.add, selected);
	        Set<Set<T>> result = new HashSet<Set<T>>();
	        for (T item : pool) {
	            result.addAll(
	                    _combination(
	                            apply(selected, Operation.add, item), // item を選択済みに変更
	                            depth - 1,
	                            apply(pool, Operation.remove, item)  // pool の中からは取り除く
	                    )
	            );
	        }
	        return result;
	    }
	    public static<T> Set<Set<T>> combination2(Set<T> src, int k) {return _combination(new HashSet<T>(), k, src);}


}
