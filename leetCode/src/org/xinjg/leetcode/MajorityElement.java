package org.xinjg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	 public int majorityElement(int[] num) {
	        int ret=num[0];
	        int rate = num.length/2;
	        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	        int cnt=0;
	        for (int i = 0; i < num.length; i++) {
	        	cnt = map.get(num[i])==null?0:map.get(num[i])+1;
	        	if (cnt>=rate) {
					return num[i];
				}
				map.put(num[i],cnt );
			}
	        return ret;
	    }
}
