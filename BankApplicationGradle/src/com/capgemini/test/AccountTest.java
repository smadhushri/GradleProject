package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	AccountService accountService;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void createAccountTest() throws InsufficientInitialBalanceException{
		Account account = new Account();
		account.setAccountNumber(60012);
		account.setAmount(1500);
		when(accountRepository.save(account)).thenReturn(true);		
		Assert.assertEquals(account, accountService.createAccount(60012,1500));	
		
	}

	@Test(expected = com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void createAccountExceptionTest() throws InsufficientInitialBalanceException{
		Account account = accountService.createAccount(60012,10);
		//return account;
	}
	
}
