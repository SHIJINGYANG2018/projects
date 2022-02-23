package mianshixuexi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> aList=new ArrayList<Integer>();
		System.out.println(Integer.MAX_VALUE);
		
		int[]ss=new int[10];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=i;
			if(i>5) {
				ss[i]=0;
			}
		}
		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i]+"  ");
		}
		System.out.println();
		System.arraycopy(ss, 0, ss,0, 10);
		//ss[1]=99;

		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i]+"  ");
			aList.add(i);
		}
		ss=Arrays.copyOf(ss, 11);
		System.out.println(ss.length);
		
		
		//三种遍历方式
		//第一种  迭代器
		Iterator<Integer>intIterable=aList.iterator();
		while (intIterable.hasNext()) {
			System.out.print(intIterable.next()+" ");
		}
		
		//for
		for(Integer integer: aList) {
			System.out.print(integer+" ");
		}
		for (int i = 0; i < aList.size(); i++) {
			System.out.print(aList.get(i));
		}
		
	}
}
