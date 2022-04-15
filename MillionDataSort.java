import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalDateTime;
import java.io.FileWriter;  
import java.io.IOException;
public class MillionDataSort{
	public static void main(String args[]) throws IOException{
		List<Integer> list = new ArrayList<Integer>();
		millionDataCreation(list);
		writeToFile(list,"Unsorted List");
	
		LocalDateTime startTime = LocalDateTime.now();
		System.out.println("[START] Sorting "+list.size()+" data "+startTime);
		
		/*Sorting using stream API*/
		List<Integer> outputList = list.stream().sorted().collect(Collectors.toList());
		
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println("[STOP] Sorting "+list.size()+" data "+endTime);
		
		/*Time Duration took for sorting*/
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Time Taken for Sorting Operation using Stream API : "+duration.getSeconds()+" secs");
		
		writeToFile(outputList,"Sorted List");
			
	}
	
	public static void writeToFile(List<Integer> list,String message) throws IOException {
		System.out.println(message+" Size : "+list.size());
		FileWriter fW = new FileWriter("C:\\Classical_Coding\\output.txt", true);
		fW.write(message+":\n");
		list.forEach(e -> {
			try {
				fW.write(e.toString()+"\n");
			} catch (IOException e1) {
				e1.getMessage();
			}
		});
		fW.close();
	}
	
	public static void millionDataCreation(List<Integer> list) {
		int max = 10000000;
                int min = 1;
                int range = max - min + 1;
		for(int i = 1; i <= max; i++){
			list.add((int)(Math.random()*range + min));
		}
	}
}
