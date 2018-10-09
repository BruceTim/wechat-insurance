package cn.brucehome.wechat.insurance.common.jdbc.service.impl;

import cn.brucehome.wechat.insurance.common.jdbc.dao.BaseDao;
import cn.brucehome.wechat.insurance.common.jdbc.enums.OrderByType;
import cn.brucehome.wechat.insurance.common.jdbc.exception.NullPageSizeException;
import cn.brucehome.wechat.insurance.common.jdbc.service.BaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Bruce.Z(80021681)
 * @version v1.0
 * @className: BaseServiceImpl
 * @description: 基础数据库服务实现, 所有数据库服务实现继承该类
 * @email wenhui.zhang@szhittech.com
 * @date 2018/9/13
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return BaseDao实现类
     */
    public abstract BaseDao<Model, PK> getDao();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(Model model) {
        return getDao().insertSelective(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertListSelective(List<Model> models) {
        return getDao().insertListSelective(models);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Model model) {
        return getDao().updateByPrimaryKeySelective(model);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Model selectByPrimaryKey(PK id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<Model> selectBySelective(Model model, Integer pageNum, Integer pageSize, Map<String, OrderByType> orderByTypeMap) {
        if (pageNum == null) {
            if (pageSize != null) {
                PageHelper.startPage(1, pageSize);
            }
        } else {
            if (pageSize == null) {
                throw new NullPageSizeException();
            } else {
                PageHelper.startPage(pageNum, pageSize);
            }
        }
        if (orderByTypeMap != null && orderByTypeMap.size() > 0) {
            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<String, OrderByType> entry : orderByTypeMap.entrySet()) {
                buffer.append(entry.getKey()).append(entry.getValue().getValue()).append(" ");
            }
            PageHelper.orderBy(buffer.toString());
        }
        return getDao().selectBySelective(model);
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public int selectCountBySelective(Model model) {
        return getDao().selectCountBySelective(model);
    }
}
