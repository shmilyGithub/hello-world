package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("xxx="+getStringDay(new Date(),-1));
		System.out.println("xxx="+getStringDay(new Date(),0));
		System.out.println("xxx="+getStringDay(new Date(),1));
		System.out.println("xxx="+getStringDay(new Date(),2));
	}
	/**
	 * 获取当前时间后几天
	 * @param date
	 * @param num
	 * @return
	 */
	public static  String getStringDay(Date date,int num) {  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DATE, num);  
        date = calendar.getTime();  
		return  format.format(date);
    }
	/**
	 * 验证银行卡号是否符合规则
	 * 
	 * @param number
	 * @return
	 */
	public static boolean luhnVerify(String number) {
		int s1 = 0, s2 = 0;
		String reverse = new StringBuffer(number).reverse().toString();
		System.out.println("reverse"+reverse);
		for (int i = 0; i < reverse.length(); i++) {
			int digit = Character.digit(reverse.charAt(i), 10);
			System.out.println("digit"+digit);
			if (i % 2 == 0) {
				s1 += digit;
			} else {
				s2 += 2 * digit;
				if (digit >= 5) {
					s2 -= 9;
				}
			}
		}
		return (s1 + s2) % 10 == 0;
	}
	
	public static int allCompareTo(Date frist, Date second) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			frist = sdf.parse(sdf.format(frist));
			second = sdf.parse(sdf.format(second));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar time1 = Calendar.getInstance();
		time1.setTime(frist);
		Calendar time2 = Calendar.getInstance();
		time2.setTime(second);

		return time1.compareTo(time2);
	}

}
