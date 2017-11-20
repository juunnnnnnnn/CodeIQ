package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Combination {
	public static void main(String[]args){
		int lattice;
		lattice=4;

		//座標を生成
		ArrayList<Tuple2<Integer, Integer>> ar= new ArrayList<Tuple2<Integer, Integer>>();
		for(int i=0; i<lattice; i++){
			for (int j = 0; j<lattice;j++){
				Tuple2<Integer, Integer> tuple2=Tuple.of(i, j);
				ar.add(tuple2);
				System.out.println("x:"+tuple2.car);
				System.out.println("y:"+tuple2.cdr.car);

			}
		}

		//試し　あとで消す
		System.out.println("arを出力");
		System.out.println("x:"+ar.get(0).car);
		System.out.println("y:"+ar.get(0).cdr.car);
		System.out.println("x:"+ar.get(15).car);
		System.out.println("y:"+ar.get(15).cdr.car);


		//組み合わせを計算
		Combination combination = new Combination();
		Integer intArray[]= new Integer[(int) Math.pow(lattice,2)];

		for(Integer h= 0; h<intArray.length; h++){
			intArray[h]=h;
			//あとで消す
			System.out.println("intArrayの値"+intArray[h]);
		}


		//以下①はうまくいった処理
//		ArrayList<Integer> n1 = new ArrayList<>(Arrays.asList(1,2,3,4));//与えられた数字4として、仮おき

		ArrayList<Integer> n1 = new ArrayList<>(Arrays.asList(combination.combining(lattice)));//与えられた数字4として、仮おき

		combination.getCombination(n1,2);
	}
//main終わり


	//配列をカンマ区切りの文字列に
	public	Integer[] combining(Integer lat){
		Integer[] ary = new Integer[lat];
		//StringBuilder builder = new StringBuilder();

		for(int d =0; d<lat;d++){
			ary[d]=d;
			//builder.append(ary[d]).append(",");
		}
		//Integer result = builder.substring(0,builder.length()-1);
		//return result;
		return ary;
	}


//組み合わせのアルゴリズム（nCr）
	public static Set<ArrayList<Integer>> getCombination(ArrayList<Integer> n, Integer r){
		Set<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
		combination(n,r,ans);
		for(ArrayList<Integer>e:ans){

			//あとで消す
			System.out.println("組み合わせを表示");

			System.out.println(e.toString());
			System.out.println(e.get(0));
			System.out.println(e.get(1));
		}
		System.out.println("length:  "+ans.size());
		return ans;
		}

	private static void combination(ArrayList<Integer> n, Integer r,Set<ArrayList<Integer>> ans){
		if (n.size()==r){
			ans.add(n);
			return;
		}
		for(int i = 0;i<n.size();i++){
			ArrayList<Integer> N = new ArrayList<Integer>();
			N.addAll(n);
			N.remove(i);
			combination(N, r, ans);
			}
		}

	//格子の中に、何個の直線があるか調べる関数
	private static int linearEquation(){
		return 0;

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


}

