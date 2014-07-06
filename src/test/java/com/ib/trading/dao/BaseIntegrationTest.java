package com.ib.trading.dao;

import javax.persistence.PersistenceContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/dao.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseIntegrationTest {
}
