import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SampleDate {
	
	
	public static void main(String[] args) {
		
	}
	Date d1 = null;
	Calendar cal= Calendar.getInstance();
	//cal.add(Calendar.DATE, days);
	Date d= cal.getTime();
     //System.out.println(d);
	//SimpleDateFormat sdf=new SimpleDateFormat("MM/DD/YYYY");
     //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     SimpleDateFormat sdf = new SimpleDateFormat("Mm/dd/yy");
	String date=sdf.format(d);
	  //System.out.println("MM/DD/YYYY -> " + date);
	  

}
