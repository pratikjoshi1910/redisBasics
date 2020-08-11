
public class Builder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Computer comp = new Computer.ComputerBuilder(
				"500 GB", "2 GB").setBluetoothEnabled(true)
				.setGraphicsCardEnabled(true).build();	
		DataDemo x = new DataDemo.Builder("x", "y").setBluetooth("x").build();
		System.out.println(x.getBluetooth());

	}

}
