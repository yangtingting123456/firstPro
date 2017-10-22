package edu.ytt.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ytt.model.ModelUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * ModelUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.ytt.model.ModelUser
 * @author MyEclipse Persistence Tools
 */
public class ModelUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ModelUserDAO.class);
	// property constants
	public static final String UPW = "upw";

	protected void initDao() {
		// do nothing
	}

	public void save(ModelUser transientInstance) {
		log.debug("saving ModelUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ModelUser persistentInstance) {
		log.debug("deleting ModelUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ModelUser findById(java.lang.String id) {
		log.debug("getting ModelUser instance with id: " + id);
		try {
			ModelUser instance = (ModelUser) getHibernateTemplate().get(
					"edu.ytt.model.ModelUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ModelUser instance) {
		log.debug("finding ModelUser instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ModelUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ModelUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUpw(Object upw) {
		return findByProperty(UPW, upw);
	}

	public List findAll() {
		log.debug("finding all ModelUser instances");
		try {
			String queryString = "from ModelUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ModelUser merge(ModelUser detachedInstance) {
		log.debug("merging ModelUser instance");
		try {
			ModelUser result = (ModelUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ModelUser instance) {
		log.debug("attaching dirty ModelUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ModelUser instance) {
		log.debug("attaching clean ModelUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ModelUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ModelUserDAO) ctx.getBean("ModelUserDAO");
	}
}