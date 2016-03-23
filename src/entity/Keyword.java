package entity;

public class Keyword {
	private String name;
	private int id;
	private int passOrNot;
	private String localPath;
	private String noPassReason;
	private String remark;
	//无参构造函数
		public Keyword() {
			super();
		}
	    //有参构造函数
		public Keyword(String name, int id,int passOrNot,String localPath,String noPassReason,String remark) {
			super();
			this.name = name;
			this.id = id;
			this.localPath = localPath;
			this.noPassReason = noPassReason;
			this.remark = remark;			
		}	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPassOrNot() {
			return passOrNot;
		}
		public void passOrNot(int passOrNot) {
			this.passOrNot = passOrNot;
		}
		public String getReason() {
			return noPassReason;
		}
		public void setReason(String noPassReason) {
			this. noPassReason =  noPassReason;
		}
		public String getRemark() {
			return remark;
		}
		public void setgetRemark(String remark) {
			this. remark =  remark;
		}
}
