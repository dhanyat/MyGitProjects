package Input;
//adding the my first java comments
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateDemo {
	
	public static void main(String[] args){
		
		Date d= new Date();
		//t = d.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss");
		String time = sdf.format(d);
		System.out.println(time);
		
		System.out.println(d);
		
	}

}
