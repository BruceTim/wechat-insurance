package cn.brucehome.wechat.insurance.common.jdbc.dao;

import java.util.List;

/**
 * @author Bruce.Z(80021681)
 * @version 1.0
 * @description: 所有自定义Dao的顶级接口, 封装常用的增删查改操作,可以通过Mybatis Generator Maven 插件自动生成Dao,也可以手动编码,然后继承GenericDao 即可.
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 * @interfaceName: BaseDao
 * @email wenhui.zhang@szhittech.com
 * @date 2018/9/13
 */
public interface BaseDao<Model, PK> {

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
     * 通过条件, 查询列表
     *
     * @param model 条件对象
     * @return 返回结果对象列表
     */
    List<Model> selectBySelective(Model model);

    /**
     * 通过条件, 查询数量
     *
     * @param model 条件对象
     * @return 返回数量
     */
    int selectCountBySelective(Model model);

}
