
public class DataDemo {

	//required parameters
	private String HDD;
	private String RAM;
	
	private String bluetooth;

	private DataDemo(Builder builder) {
		// TODO Auto-generated constructor stub
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.bluetooth = builder.bluetooth;

	}

	public String getHDD() {
		return HDD;
	}

	public void setHDD(String hDD) {
		HDD = hDD;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public String getBluetooth() {
		return this.bluetooth;
	}

	public static class Builder 
	{
		private String HDD;
		private String RAM;
		
		private String bluetooth;
		
	
		public Builder setBluetooth (String hDD) {
			this.bluetooth = hDD;
			return this;
		}
		
		public String getBluetooth() {
			return bluetooth;
		}

		public DataDemo build()
		{
			return new DataDemo(this);
		}
		public Builder (String hdd,String ram)
		{
			this.HDD = hdd;
			this.RAM = ram;
		}
	}

	
	
}
