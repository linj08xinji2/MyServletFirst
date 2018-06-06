package upperlower;

public class UpperLowerVO {
	public String pk_myprojectid; 
	public String pk_myhousecusid; 
	public String vhcell; 
	public String getPk_myprojectid() {
		return pk_myprojectid;
	}
	public void setPk_myprojectid(String pk_myprojectid) {
		this.pk_myprojectid = pk_myprojectid.toLowerCase();
	}
	public String getPk_myhousecusid() {
		return pk_myhousecusid;
	}
	public void setPk_myhousecusid(String pk_myhousecusid) {
		this.pk_myhousecusid = pk_myhousecusid.toUpperCase();
	}
	public String getVhcell() {
		return vhcell;
	}
	public void setVhcell(String vhcell) {
		this.vhcell = vhcell;
	}
	@Override
	public String toString() {
		return "UpperLowerVO [pk_myprojectid=" + pk_myprojectid
				+ ", pk_myhousecusid=" + pk_myhousecusid + ", vhcell=" + vhcell
				+ "]";
	}
	
	
}
