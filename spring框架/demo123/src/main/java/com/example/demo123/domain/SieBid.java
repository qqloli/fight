package com.example.demo123.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sie_bid_t")
public class SieBid {
    @Id
    private Long id; //序列号

    @Column(name = "serial_num")
    private String serialNum; // 流水号

    @Column(name = "user_id")
    private Integer user_id; // 申请人id

    @Column(name = "zh_name")
    private String zhName;   // 申请人中文名

    @Column(name = "org_name")
    private String orgName;   // 所属部门名称

    @Column(name = "is_new")
    private String isNew;      // 是否新报价

    @Column(name = "old_bid_num")
    private String oldBidNum;  // 旧投标/报价单号

    @Column(name = "customer_manager")
    private String customerManager;  // 客户经理

    @Column(name = "sale_area")
    private String saleArea;     // 销售区域

    @Column(name = "pre_sale_po_code")
    private String preSalePoCode;  // 售前项目编码

    @Column(name = "pre_sale_po_name")
    private String preSalePoName;   // 售前项目名称

    @Column(name = "delivery_org_name")
    private String deliveryOrgName;   // 交付主导部门

    @Column(name = "sale_stage")
    private String saleStage;       // 销售阶段

    @Column(name = "customer_name")
    private String customerName;     // 客户名称

    @Column(name = "customer_code")
    private String customerCode;      // 客户编码

    @Column(name = "pre_sale_owner")
    private String preSaleOwner;       // 售前负责人

    @Column(name = "product_type")
    private String productType;         // 产品类型

    @Column(name = "contract_entity")
    private String contractEntity;       // 签约主体

    @Column(name = "currency")
    private String currency;             // 币种

    @Column(name = "recipient_name")
    private String recipientName;         // 收件人姓名

    @Column(name = "recipient_tel")
    private String recipient_tel;          // 收件人电话

    @Column(name = "recipient_addr")
    private String recipientAddr;          // 收件人地址

    @Column(name = "quote_date")
    private LocalDateTime quoteDate;        // 报价提交时间

    @Column(name = "bid_dead_line")
    private String bidDeadLine;              // 投标截止日期

    @Column(name = "sale_category")
    sale_category

    @Column(name = "is_sh_external")
            is_sh_external

    @Column(name = "maintenance_period")
    maintenance_period

    @Column(name = "sh_company")
            sh_company

    @Column(name = "impl_external_quote")
    impl_external_quote

    @Column(name = "impl_bu_quote")
            impl_bu_quote

    @Column(name = "impl_invoice_tax_rate")
    impl_invoice_tax_rate

    @Column(name = "oper_external_quote")
            oper_external_quote

    @Column(name = "oper_bu_quote")
    oper_bu_quote

    @Column(name = "oper_invoice_tax_rate")
            oper_invoice_tax_rate

    @Column(name = "self_external_quote")
    self_external_quote

    @Column(name = "self_bu_quote")
            self_bu_quote

    @Column(name = "self_invoice_tax_rate")
    self_invoice_tax_rate

    @Column(name = "out_external_quote")
            out_external_quote

    @Column(name = "out_purchase_cost")
    out_purchase_cost

    @Column(name = "out_invoice_tax_rate")
            out_invoice_tax_rate

    @Column(name = "hard_external_quote")
    hard_external_quote

    @Column(name = "hard_purchase_cost")
            hard_purchase_cost

    @Column(name = "hard_invoice_tax_rate")
    hard_invoice_tax_rate

    @Column(name = "resource_external_quote")
            resource_external_quote

    @Column(name = "resource_purchase_cost")
    resource_purchase_cost

    @Column(name = "resource_invoice_tax_rate")
            resource_invoice_tax_rate

    @Column(name = "is_back_to_back")
    is_back_to_back

    @Column(name = "dist_external_quote")
            dist_external_quote

    @Column(name = "predict_dist_total_cost")
    predict_dist_total_cost

    @Column(name = "predict_dist_gp")
            predict_dist_gp

    @Column(name = "bid_total_day")
    bid_total_day

    @Column(name = "standard_person_unit_price")
            standard_person_unit_price

    @Column(name = "predict_hard_soft_gp")
    predict_hard_soft_gp

    @Column(name = "bid_total_amount")
            bid_total_amount

    @Column(name = "comb_person_day_amount")
    comb_person_day_amount

    @Column(name = "impl_total_amount")
            impl_total_amount

    @Column(name = "avg_person_price")
    avg_person_price

    @Column(name = "impl_discount_price")
            impl_discount_price

    @Column(name = "discount")
    discount

    @Column(name = "is_lock")
            is_lock

    @Column(name = "tmp_uuid")
    tmp_uuid

    @Column(name = "extra")
            extra

    @Column(name = "data_state")
    data_state

    @Column(name = "created_by")
            created_by

    @Column(name = "created_date")
    created_date

    @Column(name = "last_modified_by")
            last_modified_by

    @Column(name = "last_modified_date")
    last_modified_date
}
