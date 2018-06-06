package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;



public class StringAppend {
  public static void main(String[] args) {
	 /* StringBuilder sBuilder=new StringBuilder();
		sBuilder.append(" in ('");
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
	for (int i = 0; i < list.size(); i++) {
		if(i==list.size()-1){
			sBuilder.append(list.get(i)).append("')");
		}else{
			sBuilder.append(list.get(i)).append("','");
		}
	}*/
	  List<String> list=new ArrayList<String>();
	  StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(" select * from syn_managementsec m where m.dr=0 and ");
		sBuilder.append(" m.pk_myprojectid in ('");
		for (int i = 0; i < 1115; i++) {
			list.add(i+"");
		}
		
		System.out.println(new StringAppend().getOracleSQLIn(list,list.size(),"pk_myprojectid"));
}
  
  private String getOracleSQLIn(List<String> ids, int count, String field) {
	    count = Math.min(count, 1000);
	    int len = ids.size();
	    int size = len % count;
	    if (size == 0) {
	        size = len / count;
	    } else {
	        size = (len / count) + 1;
	    }
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < size; i++) {
	        int fromIndex = i * count;
	        int toIndex = Math.min(fromIndex + count, len);
//	        String productId = StringUtils.defaultIfEmpty(StringUtils.join(ids.subList(fromIndex, toIndex), "','"), "");
	        String productId =   StringUtils.defaultIfEmpty(StringUtils.join(ids.subList(fromIndex, toIndex).toArray(), "','"), "");
	        if (i != 0) {
	            builder.append(" or ");
	        }
	        builder.append(field).append(" in ('").append(productId).append("')");
	    }
	    return  StringUtils.defaultIfEmpty(builder.toString(), field + " in ('')");
	}
  
}
