package combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Combination {

	public static Set<ArrayList<Integer>> getCombination(ArrayList<Integer> n, Integer r){
		Set<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
		combination(n,r,ans);
		for(ArrayList<Integer>e:ans){
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
	}
