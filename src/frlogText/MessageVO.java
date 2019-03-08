package frlogText;


public class MessageVO {

	
	public String reportname;
	
	public String username;
	
	public String ip;
	
	public String starttime;

	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Override
	public String toString() {
		return reportname + "\t" + username+ "\t" + ip + "\t" + starttime;
	}
	
	
}
