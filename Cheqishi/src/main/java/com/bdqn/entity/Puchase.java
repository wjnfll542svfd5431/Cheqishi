package com.bdqn.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * 采购配件实体类
 * @author 王江南
 *
 */
public class Puchase {
	private int purchaseId;//采购编号
	private Supplier supplier;//外键
	@NotEmpty(message="配件名称不能为空")
	private String purchaseName;//采购配件名称
	@NotNull(message="单价不能为空")
	private double purchaseUnit;//单价
	private int purchaseNumber;//数量
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	private double purchaseTotalsum;//总金额
	@Pattern(regexp="^\\d{4}-\\d{1,2}-\\d{1,2}",message="格式有误")
	private String purchaseDate;//采购时间
	private String purchaseQuality;//质保
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getPurchaseName() {
		return purchaseName;
	}
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	public double getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(double purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public double getPurchaseTotalsum() {
		return purchaseTotalsum;
	}
	public void setPurchaseTotalsum(double purchaseTotalsum) {
		this.purchaseTotalsum = purchaseTotalsum;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseQuality() {
		return purchaseQuality;
	}
	public void setPurchaseQuality(String purchaseQuality) {
		this.purchaseQuality = purchaseQuality;
	}
	public String getDatetimeState() {
		return datetimeState;
	}
	public void setDatetimeState(String datetimeState) {
		this.datetimeState = datetimeState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String datetimeState;//状态
	private String remark;//备注
	@Override
	public String toString() {
		return "Puchase [purchaseId=" + purchaseId + ", supplier=" + supplier + ", purchaseName=" + purchaseName
				+ ", purchaseUnit=" + purchaseUnit + ", purchaseNumber=" + purchaseNumber + ", purchaseTotalsum="
				+ purchaseTotalsum + ", purchaseDate=" + purchaseDate + ", purchaseQuality=" + purchaseQuality
				+ ", datetimeState=" + datetimeState + ", remark=" + remark + "]";
	}
	
	
}
