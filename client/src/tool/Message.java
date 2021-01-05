package tool;

public class Message implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String no;
	private String time;
	private String state;
	private String delay;
	private String CPU;
	
	
	public Message(String no, String time, String state, String delay, String cPU) {
		this.no = no;
		this.time = time;
		this.state = state;
		this.delay = delay;
		CPU = cPU;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	

	
	
}
