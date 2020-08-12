package euler;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class p79 {

	static final String[] ATTEMPTS = {"319","680","180","690","129","620","762","689","762","318","368","710","720","710","629","168","160","689","716","731","736","729","316","729","729","710","769","290","719","680","318","389","162","289","162","718","729","319","790","680","890","362","319","760","316","729","380","319","728","716"};
	
	public static void main(String[] args) {
		ArrayList<SimpleEntry<String,String>> edges = new ArrayList<>();
		//Create edges for all attempts
		for(int x = 0; x < ATTEMPTS.length; x++){
			SimpleEntry<String,String> entry = new SimpleEntry<String,String>(""+ ATTEMPTS[x].charAt(0),""+ATTEMPTS[x].charAt(1));
			
			//Check for duplicates
			if(!entryInList(entry, edges)){
				edges.add(entry);
			}
			
			entry = new SimpleEntry<String,String>(""+ ATTEMPTS[x].charAt(1),""+ATTEMPTS[x].charAt(2));
			//Check for duplicates
			if(!entryInList(entry, edges)){
				edges.add(entry);
			}
		}
		
		//Create list of elements that will be removed from the edges list
		ArrayList<SimpleEntry<String,String>> removable = new ArrayList<>();
		
		//Iterate through every edge and look if it can be expressed by another edge
		for(SimpleEntry<String,String> listEntry : edges){
			if(isThereAnotherWay(listEntry.getKey(), listEntry.getValue(), edges, true)){
				removable.add(listEntry);
			}
		}
		edges.removeAll(removable);
		//All edges are left, that express the relation between the code, simply combine them one by one
		for(SimpleEntry<String,String> listEntry : edges){
			System.out.println(listEntry.getKey() + " -> " + listEntry.getValue());	
		}
	}
	
	public static boolean entryInList(SimpleEntry<String,String> entry, ArrayList<SimpleEntry<String,String>> list){
		
		for(SimpleEntry<String,String> listEntry : list){
			if(entry.getKey().equals(listEntry.getKey()) && entry.getValue().equals(listEntry.getValue())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isThereAnotherWay(String from, String to, ArrayList<SimpleEntry<String,String>> edges, boolean first){
		
		for(SimpleEntry<String,String> listentry : edges){
			//If its the direct entry between from -> to
			if(listentry.getKey().equals(from) && listentry.getValue().equals(to)){
				//We don't want to cancel in the first run since we search the alternative for exactly that edge
				if(first){
					continue;
				}
				//We found a edge that can be used to express the starting edge
				else{
					return true;
				}
			}
	
			if(listentry.getKey().equals(from)){
				//Check recursively if we can fo further down to find the "to" 
				if(isThereAnotherWay(listentry.getValue(), to, edges, false)){
					return true;
				}
			}
		}
		
		return false;
	}
	
}
