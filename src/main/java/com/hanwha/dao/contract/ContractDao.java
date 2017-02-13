package com.hanwha.dao.contract;

/**
 * Created by iabad on 07/11/2016.
 */

import com.hanwha.dao.HanwhaDao;
import com.hanwha.model.ContractMasterModel;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class ContractDao extends HanwhaDao {

    public ContractDao(SqlSession session) {
        super(session);
    }

    public ContractMasterModel getContractMaster(ContractMasterModel model) {
        return (ContractMasterModel) session.selectOne("getFinContractMaster", model);
    }

    public int insertContractMaster(ContractMasterModel systemProperty) {
        int result = 0;
        result = session.insert("insertFinContractMaster", systemProperty);
        return result;
    }

    public int updateContractMaster(ContractMasterModel systemProperty) {
        int result = 0;
        result = session.update("updateFinContractMaster", systemProperty);
        return result;
    }

    public int deleteContractMaster(ContractMasterModel systemProperty) {
        int result = 0;
        result = session.delete("deleteFinContractMaster", systemProperty);
        return result;
    }


    public List listContractMaster() {
        List list = session.selectList("listAllFinSchemaMap", null);
        return list;
    }

    public int countTotalList(HashMap parameterObject) {
        Integer count = (Integer) session.selectOne("countTotalFinContractMaster", parameterObject);
        return count == null ? 0 : count.intValue();
    }

    public List<ContractMasterModel> listAvailableContractMasterMap(HashMap parameterObject, boolean includeNavigation) {
        if (includeNavigation)
            return session.selectList("listFinContractMasterMap", parameterObject);
        else
            return session.selectList("listAllFinContractMasterMap", parameterObject);
    }
}