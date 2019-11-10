package com.bdqn.entity;
/**
 * 供应商实体类
 * @author 王江南
 *
 */
public class Supplier {
	private int supplierId;//编号
	private String supplierContent;//供应商名称
	private String supplierAddress;//供应商地址
	private String supplierTelephone;//供应商电话
	private String supplierName;//负责人
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierContent() {
		return supplierContent;
	}
	public void setSupplierContent(String supplierContent) {
		this.supplierContent = supplierContent;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierTelephone() {
		return supplierTelephone;
	}
	public void setSupplierTelephone(String supplierTelephone) {
		this.supplierTelephone = supplierTelephone;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierContent=" + supplierContent + ", supplierAddress="
				+ supplierAddress + ", supplierTelephone=" + supplierTelephone + ", supplierName=" + supplierName + "]";
	}
}
