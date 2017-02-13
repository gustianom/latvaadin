package com.hanwha.model;

import java.io.Serializable;

/**
 * Created by iabad on 04/11/2016.
 */
public class ContractMasterModel implements Serializable{
    private Long policyId;
    private String policyCode;
    private String applyCode;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }
}
