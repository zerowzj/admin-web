package com.company.project.adminweb.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 基础Dao实现
 *
 * @author wangzhj
 */
public abstract class BaseDaoImpl<E extends BaseEO> extends SqlSessionDaoSupport implements BaseDao<E> {

    private static final String DOT = ".";

    private static final String SQL_ID_INSERT = "insert";

    private static final String SQL_ID_DELETE = "delete";

    private static final String SQL_ID_UPDATE = "update";

    private static final String SQL_ID_GET = "get";

    @Override
    public final E insert(final E entity) {
        String sqlId = getSqlId(SQL_ID_INSERT);
        int count = getSqlSession().insert(sqlId, entity);
        return entity;
    }

    @Override
    public final int delete(final Serializable id) {
        String sqlId = getSqlId(SQL_ID_DELETE);
        int count = getSqlSession().delete(sqlId, id);
        return count;
    }

    @Override
    public final int update(final E entity) {
        String sqlId = getSqlId(SQL_ID_UPDATE);
        int count = getSqlSession().update(sqlId, entity);
        return count;
    }

    @Override
    public final E get(final Serializable id) {
        String sqlId = getSqlId(SQL_ID_GET);
        E entity = getSqlSession().selectOne(sqlId, id);
        return entity;
    }

    /**
     * 获取sqlId
     *
     * @param sqlId
     * @return String
     */
    protected final String getSqlId(String sqlId) {
        return this.getClass().getPackage().getName() + DOT + sqlId;
    }

    @Override
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
