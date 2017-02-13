package com.hanwha.model;

import java.io.Serializable;

/**
 * Created by iabad on 16/11/2016.
 */
public class SchemaModel implements Serializable {
    private String schemaName;
    private Integer schemaId, financingType, agencyLevel, productionSource, periodFactor;
    private Double basicFinancingAmount, justification, productionSourceAmount;
    private String financingRange;

    public Integer getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(Integer schemaId) {
        this.schemaId = schemaId;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Integer getFinancingType() {
        return financingType;
    }

    public void setFinancingType(Integer financingType) {
        this.financingType = financingType;
    }

    public Integer getAgencyLevel() {
        return agencyLevel;
    }

    public void setAgencyLevel(Integer agencyLevel) {
        this.agencyLevel = agencyLevel;
    }

    public Integer getProductionSource() {
        return productionSource;
    }

    public void setProductionSource(Integer productionSource) {
        this.productionSource = productionSource;
    }

    public Integer getPeriodFactor() {
        return periodFactor;
    }

    public void setPeriodFactor(Integer periodFactor) {
        this.periodFactor = periodFactor;
    }

    public Double getBasicFinancingAmount() {
        return basicFinancingAmount;
    }

    public void setBasicFinancingAmount(Double basicFinancingAmount) {
        this.basicFinancingAmount = basicFinancingAmount;
    }

    public Double getJustification() {
        return justification;
    }

    public void setJustification(Double justification) {
        this.justification = justification;
    }

    public String getFinancingRange() {
        return financingRange;
    }

    public void setFinancingRange(String financingRange) {
        this.financingRange = financingRange;
    }

    public Double getProductionSourceAmount() {
        return productionSourceAmount;
    }

    public void setProductionSourceAmount(Double productionSourceAmount) {
        this.productionSourceAmount = productionSourceAmount;
    }
}
