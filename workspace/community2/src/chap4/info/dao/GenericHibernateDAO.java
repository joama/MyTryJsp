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
	// �O������(���[)�������O������
	private Class<T> persistentClass;
	
	// �غc���A�ǤJ�ѼƬ����骫�����O
	public GenericHibernateDAO(Class<T> persistentClass){
		this.persistentClass = persistentClass;
	}
	
	// �o����[�ƪ������O
	public Class<T> getPersistentClass(){
		return persistentClass;
	}
	
	/**
     * �o���e�u�{��Session��H�����
     * 
     * @return
     */
    protected Session getSession() 
    {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
	 * �q�LID�ӱo������H
	 * 
	 * @param id �����H�����Ѳ�
	 * @param lock �ϥΪ���Ҧ�
	 * @return �ӥD��ȹ����������H
	
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
     * �N�����H���[��
     * 
     * @param entity �ݭn�i����[�ƾާ@�������H
     * @return ���[�ƪ������H
     */
    @SuppressWarnings("unchecked")
    public T makePersistent(T entity) 
    {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    /**
     * �N�����H�ܬ����A
     * 
     * @param entity �ݭn���ܬ����A�������H
     */
    public void makeTransient(T entity) 
    {
        getSession().delete(entity);
    }

    
    
    
    
    //getByHsql��k��^HQL�y�yhsql���d�ߵ��G�C
    public List<T> getByHsql(String hsql) {
    	//getSession��oSession�CSession��createQuery��k�����@��HQL�d�߻y�y�A�Ыجd�ߡ]Query�^
    	Query query = getSession().createQuery(hsql);
    	return query.list();
    }

   //getByCriteria��k��^�ŦX�d�߱��󪺫��[��H���
    @SuppressWarnings("unchecked")
    protected List<T> getByCriteria(Criterion... criterion) {
    	Criteria crit = getSession().createCriteria(getPersistentClass());
    	for (Criterion c : criterion) {
    		crit.add(c);
    	}
    	return crit.list();
    }
    
    
    //�Ӥ�k�q�Lid�ӱo����[��H���
    @SuppressWarnings("unchecked")
    public T getById(ID id) {
    	T entity = (T) getSession().get(getPersistentClass(), id);
    	return entity;
    }
    
    
    
    /**
     * �o��Ҧ��������H
     * 
     * @return �Ҧ��������H
     */
    //�Ӥ�k��^persistentClass���w�����[��H���Ҧ����
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
    	return getByCriteria();
    }

    
    /**
     * �ھڹ�H���ݩʩM�ݩʪ��Ȩӱo�캡�����󪺹����H
     * 
     * @param exampleInstance �d�ߪ�����
     * @return �������󪺹����H
     */
  //�Ӥ�k�ھڶǤJ�����[��H��Ҫ�^�ŦX���󪺫��[��H���
    @SuppressWarnings("unchecked")
    public List<T> getByExample(T exampleInstance) {
    	return getByCriteria(Example.create(exampleInstance));
    }

}
