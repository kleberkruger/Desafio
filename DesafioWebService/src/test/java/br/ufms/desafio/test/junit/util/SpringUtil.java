/*
 * Copyright (C) 2016 kleberkruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.test.junit.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 *
 * @author kleberkruger
 */
public class SpringUtil {

    private static SpringUtil instance;
    protected AbstractXmlApplicationContext ctx;
    // Hibernate
    protected HibernateTransactionManager txManager;
    private Session session;

    private SpringUtil() {
        try {
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        } catch (BeansException e) {
            throw e;
        }
    }

    public static SpringUtil getInstance() {
        if (instance == null) {
            instance = new SpringUtil();
        }
        return instance;
    }

    @SuppressWarnings("rawtypes")
    public Object getBean(Class c) {
        if (ctx == null) {
            return null;
        }
        if (session == null) {
            openSession();
        }
        String[] beanNamesForType = ctx.getBeanNamesForType(c);
        if (beanNamesForType == null || beanNamesForType.length == 0) {
            return null;
        }
        String name = beanNamesForType[0];
        Object bean = getBean(name);
        return bean;
    }

    public Object getBean(String name) {
        if (ctx == null) {
            return null;
        }
        if (session == null) {
            openSession();
        }
        Object bean = ctx.getBean(name);
        return bean;
    }

    /**
     * Deixa a Session viva nesta Thread. Mesma coisa que uma Thread de uma
     * requisição web utilizando o filtro "OpenSessionInViewFilter"
     * 
     * @return 
     */
    public Session openSession() {
        if (ctx != null) {
            txManager = (HibernateTransactionManager) ctx
                    .getBean("transactionManager");
            SessionFactory sessionFactory = txManager.getSessionFactory();
            session = sessionFactory.openSession();
            TransactionSynchronizationManager.bindResource(sessionFactory,
                    new SessionHolder(session));
        }
        return session;
    }

    /**
     * Remove a Session da Thread
     */
    public void closeSession() {
        if (ctx != null && txManager != null) {
            SessionFactory sessionFactory = txManager.getSessionFactory();
            TransactionSynchronizationManager.unbindResource(sessionFactory);
            SessionFactoryUtils.closeSession(session);
            session = null;
        }
    }

    public Session getSession() {
        return session;
    }

    public SessionFactory getSessionFactory() {
        SessionFactory sf = txManager.getSessionFactory();
        return sf;
    }
}
