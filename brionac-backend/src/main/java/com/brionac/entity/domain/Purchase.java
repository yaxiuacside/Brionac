package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 采购表
 * @TableName purchase
 */
@TableName(value ="purchase")
@Data
public class Purchase implements Serializable {
    /**
     * 采购id
     */
    @TableId(value = "purchase_id", type = IdType.AUTO)
    private Integer purchaseId;

    /**
     * 采购编号
     */
    @TableField(value = "purchase_no")
    private String purchaseNo;

    /**
     * 进货数量
     */
    @TableField(value = "purchase_number")
    private Integer purchaseNumber;

    /**
     * 进货时间
     */
    @TableField(value = "purchase_time")
    private Date purchaseTime;

    /**
     * 收货时间
     */
    @TableField(value = "receipt_time")
    private Date receiptTime;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 商品编号
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 供应商ID
     */
    @TableField(value = "supplier_id")
    private Integer supplierId;

    /**
     * 供应商编号
     */
    @TableField(value = "supplier_no")
    private String supplierNo;

    /**
     * 供应商名称
     */
    @TableField(value = "supplier_name")
    private String supplierName;

    /**
     * 操作员编号
     */
    @TableField(value = "account_number")
    private String accountNumber;

    /**
     * 操作员名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 收货状态
     */
    @TableField(value = "receipt_status")
    private Integer receiptStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Purchase other = (Purchase) that;
        return (this.getPurchaseId() == null ? other.getPurchaseId() == null : this.getPurchaseId().equals(other.getPurchaseId()))
            && (this.getPurchaseNo() == null ? other.getPurchaseNo() == null : this.getPurchaseNo().equals(other.getPurchaseNo()))
            && (this.getPurchaseNumber() == null ? other.getPurchaseNumber() == null : this.getPurchaseNumber().equals(other.getPurchaseNumber()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
            && (this.getReceiptTime() == null ? other.getReceiptTime() == null : this.getReceiptTime().equals(other.getReceiptTime()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getSupplierNo() == null ? other.getSupplierNo() == null : this.getSupplierNo().equals(other.getSupplierNo()))
            && (this.getSupplierName() == null ? other.getSupplierName() == null : this.getSupplierName().equals(other.getSupplierName()))
            && (this.getAccountNumber() == null ? other.getAccountNumber() == null : this.getAccountNumber().equals(other.getAccountNumber()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getReceiptStatus() == null ? other.getReceiptStatus() == null : this.getReceiptStatus().equals(other.getReceiptStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPurchaseId() == null) ? 0 : getPurchaseId().hashCode());
        result = prime * result + ((getPurchaseNo() == null) ? 0 : getPurchaseNo().hashCode());
        result = prime * result + ((getPurchaseNumber() == null) ? 0 : getPurchaseNumber().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
        result = prime * result + ((getReceiptTime() == null) ? 0 : getReceiptTime().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getSupplierNo() == null) ? 0 : getSupplierNo().hashCode());
        result = prime * result + ((getSupplierName() == null) ? 0 : getSupplierName().hashCode());
        result = prime * result + ((getAccountNumber() == null) ? 0 : getAccountNumber().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getReceiptStatus() == null) ? 0 : getReceiptStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseId=").append(purchaseId);
        sb.append(", purchaseNo=").append(purchaseNo);
        sb.append(", purchaseNumber=").append(purchaseNumber);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", receiptTime=").append(receiptTime);
        sb.append(", productId=").append(productId);
        sb.append(", productNo=").append(productNo);
        sb.append(", productName=").append(productName);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierNo=").append(supplierNo);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", userName=").append(userName);
        sb.append(", receiptStatus=").append(receiptStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}