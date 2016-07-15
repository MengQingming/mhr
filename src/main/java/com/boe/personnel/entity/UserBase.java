package com.boe.personnel.entity;

public class UserBase {
	
	//用户ID
	private Integer userId;
	// 登录名  同 UserName 用户名
	private String account;
	// 登陆密码
	private String password;
	// 明文密码(修改密码)
	private String plainPassword;
	// 真实姓名
	private String name;
	//职称
	private String ranl;
	// 用户手机
	private String mobilePhone;
	// 电子邮件
	private String email;
	// 联系电话
	private String contactPhone;
	// 身份证号
	private String idCard;
	//身份证号后六位
	private String idCardLastSix;
	//组织ID
	private Integer orgId;
	//组织名称
	private String orgName;
	//工作名称
	private String jobName;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRanl() {
		return ranl;
	}
	public void setRanl(String ranl) {
		this.ranl = ranl;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIdCardLastSix() {
		return idCardLastSix;
	}
	public void setIdCardLastSix(String idCardLastSix) {
		this.idCardLastSix = idCardLastSix;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Override
	public String toString() {
		return "UserBase [userId=" + userId + ", account=" + account + ", password=" + password + ", plainPassword="
				+ plainPassword + ", name=" + name + ", ranl=" + ranl + ", mobilePhone=" + mobilePhone + ", email="
				+ email + ", contactPhone=" + contactPhone + ", idCard=" + idCard + ", idCardLastSix=" + idCardLastSix
				+ ", orgId=" + orgId + ", orgName=" + orgName + ", jobName=" + jobName + "]";
	}
	
	
}
