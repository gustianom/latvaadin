package com.hanwha.bean.contract;

import com.hanwha.bean.HanwhaHelper;
import com.hanwha.dao.contract.ContractDao;
import com.hanwha.model.ContractMasterModel;
import com.hanwha.util.Constants;
import com.hanwha.util.PagingHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

/**
 * Created by iabad on 07/11/2016.
 */
public class ContractMasterHelper extends HanwhaHelper  implements PagingHelper {
    public int insertNewContractMaster(ContractMasterModel model) throws Exception {
        int result = 0;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContractDao dao = new ContractDao(session);
            ContractMasterModel grpModel = new ContractMasterModel();
            grpModel.setPolicyCode(model.getPolicyCode());
            grpModel.setPolicyId(model.getPolicyId());
            grpModel = dao.getContractMaster(grpModel);
            if (grpModel != null)
                throw new Exception(Constants.ADD_ALREADY_EXIST);
            else {
                result = dao.insertContractMaster(model);
                if (result == 0)
                    throw new Exception(Constants.ADD_FAILED);
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new Exception(e);
        } finally {
            session.close();
        }
        return result;
    }

    public int updateContractMaster(ContractMasterModel model) throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        int ret = 0;
        try {
            ContractDao dao = new ContractDao(session);
            ret = dao.updateContractMaster(model);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new Exception(Constants.UPDATE_FAILED);
        } finally {
            session.close();
        }
        return ret;
    }

    @Override
    public List<ContractMasterModel> getCustomListRenderer(HashMap hashMap, boolean isNavigate) {
        return getListRenderer(hashMap, isNavigate);
    }

    public int countTotalList(HashMap mapList) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContractDao dao = new ContractDao(session);
            return dao.countTotalList(mapList);
        } finally {
            session.close();
        }
    }

    public List<ContractMasterModel> getListRenderer(HashMap mapList, boolean navigated) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContractDao dao = new ContractDao(session);
            return dao.listAvailableContractMasterMap(mapList, navigated);
        } finally {
            session.close();
        }
    }

    public ContractMasterModel getContractMasterDetail(ContractMasterModel model) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContractDao dao = new ContractDao(session);
            return dao.getContractMaster(model);
        } finally {
            session.close();
        }
    }

    public int deleteContractMaster(ContractMasterModel m) throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        int ret = 0;
        try {
            ContractDao dao = new ContractDao(session);
            ret = dao.deleteContractMaster(m);
            session.commit();
        } catch (Exception e) {
            session.rollback();
           /* if (e.getCause().toString().toUpperCase().indexOf(ErrorInfo.VIOLATES_FOREIGN_KEY_CONTRAINT.toUpperCase()) != -1)
                throw new Exception(Constants.DELETE_FAILED_HAVE_REFERENCE, e);
            else
                throw new Exception(Constants.DELETE_FAILED, e)*/;
        } finally {
            session.close();
        }
        return ret;

    }

    public List listContractMaster() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ContractDao dao = new ContractDao(session);
            return dao.listContractMaster();
        } finally {
            session.close();
        }
    }
    }
