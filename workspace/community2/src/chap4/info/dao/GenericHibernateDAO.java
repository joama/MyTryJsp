package chap4.info.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import chap4.info.util.HibernateUtil;

public class GenericHibernateDAO<T, ID extends Serializable> {
	// 保持實體(持久)物件類別的類型
	private Class<T> persistentClass;
	
	// 建構式，傳入參數為實體物件類別
	public GenericHibernateDAO(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	// 得到持久化物件的類別
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	/**
     * 得到當前線程的Session對象的實例
     * 
     * @return
     */
    protected Session getSession() 
    {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
	 * 通過ID來得到實體對象
	 * 
	 * @param id 實體對象的標識符
	 * @param lock 使用的鎖模式
	 * @return 該主鍵值對應的實體對象
	
    @SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) 
    {
        T entity;
        if (lock)
            entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
        else
            entity = (T) getSession().get(getPersistentClass(), id);

        return entity;
    }
 */


    /**
     * 將實體對象持久化
     * 
     * @param entity 需要進行持久化操作的實體對象
     * @return 持久化的實體對象
     */
    @SuppressWarnings("unchecked")
    public T makePersistent(T entity) 
    {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    /**
     * 將實體對象變為瞬態
     * 
     * @param entity 需要轉變為瞬態的實體對象
     */
    public void makeTransient(T entity) 
    {
        getSession().delete(entity);
    }

    
    
    
    
    //getByHsql方法返回HQL語句hsql的查詢結果。
    public List<T> getByHsql(String hsql) {
    	//getSession獲得Session。Session的createQuery方法接收一個HQL查詢語句，創建查詢（Query）
    	Query query = getSession().createQuery(hsql);
    	return query.list();
    }

   //getByCriteria方法返回符合查詢條件的持久對象實例
    @SuppressWarnings("unchecked")
    protected List<T> getByCriteria(Criterion... criterion) {
    	Criteria crit = getSession().createCriteria(getPersistentClass());
    	for (Criterion c : criterion) {
    		crit.add(c);
    	}
    	return crit.list();
    }
    
    
    //該方法通過id來得到持久對象實例
    @SuppressWarnings("unchecked")
    public T getById(ID id) {
    	T entity = (T) getSession().get(getPersistentClass(), id);
    	return entity;
    }
    
    
    
    /**
     * 得到所有的實體對象
     * 
     * @return 所有的實體對象
     */
    //該方法返回persistentClass指定的持久對象的所有實例
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
    	return getByCriteria();
    }

    
    /**
     * 根據對象的屬性和屬性的值來得到滿足條件的實體對象
     * 
     * @param exampleInstance 查詢的條件
     * @return 滿足條件的實體對象
     */
  //該方法根據傳入的持久對象實例返回符合條件的持久對象實例
    @SuppressWarnings("unchecked")
    public List<T> getByExample(T exampleInstance) {
    	return getByCriteria(Example.create(exampleInstance));
    }

}
