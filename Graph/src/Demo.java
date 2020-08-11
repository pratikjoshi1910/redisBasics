import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Data> values = new ArrayList<>(); 
		values.add(new Data());
		values.add(new Data());
		values.add(new Data());
		values.add(new Data());
		
		 for (int i=0 ;i<3;i++)
		 {
			 if (i % 2 == 0)
			 {
				 values.get(i).setPrice("22"); 
			 }
				 
		 }
		
		System.out.println(values.get(2).price);

	}

}
