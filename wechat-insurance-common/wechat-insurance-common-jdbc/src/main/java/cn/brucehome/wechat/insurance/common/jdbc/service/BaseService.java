package cn.brucehome.wechat.insurance.common.jdbc.service;

import cn.brucehome.wechat.insurance.common.jdbc.enums.OrderByType;

import java.util.List;
import java.util.Map;

/**
 * @author Bruce.Z(80021681)
 * @version 1.0
 * @interfaceName: BaseService
 * @description: 所有数据库服务的顶级接口, 封装常用的增删查改操作
 * @email wenhui.zhang@szhittech.com
 * @date 2018/9/13
 */
public interface BaseService<Model, PK> {

    /**
     * 按条件插入对象
     *
     * @param model 对象
     * @return 返回修改的行数
     */
    int insertSelective(Model model);

    /**
     * 按条件批量插入对象
     *
     * @param models 对象
     * @return 返回修改的行数
     */
    int insertListSelective(List<Model> models);

    /**
     * 更新对象
     *
     * @param model 对象
     * @return 返回修改的行数
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     * @return 返回修改的行数
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return 返回结果对象
     */
    Model selectByPrimaryKey(PK id);

    /**
     * 通过条件, 分页查询列表
     *
     * @param model    条件对象
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @param pageSize orderByTypeMap 排序规则, key为数据库列名称.value为 asc或desc
     * @return 返回结果对象列表
     */
    List<Model> selectBySelective(Model model, Integer pageNum, Integer pageSize, Map<String, OrderByType> orderByTypeMap);

    /**
     * 通过条件, 查询数量
     *
     * @param model 条件对象
     * @return 返回结果对象列表
     */
    int selectCountBySelective(Model model);

}