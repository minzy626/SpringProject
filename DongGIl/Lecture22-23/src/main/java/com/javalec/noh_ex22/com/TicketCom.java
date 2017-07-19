package com.javalec.noh_ex22.com;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.noh_ex22.Dao.Dao;
import com.javalec.noh_ex22.Dto.Dto;

public class TicketCom implements ITicketCom {

	private Dao ticketDao;
	private TransactionTemplate transactionTemplate2;
	
	
	public Dao getTicketDao() {
		return ticketDao;
	}


	public void setTicketDao(Dao ticketDao) {
		this.ticketDao = ticketDao;
	}


	public TransactionTemplate getTransactionTemplate2() {
		return transactionTemplate2;
	}


	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}


	@Override
	public void execute(final Dto ticketDto) {
		// TODO Auto-generated method stub
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// TODO Auto-generated method stub
				
				ticketDto.setAmount("1");
				ticketDao.buyTicket(ticketDto);
				
				ticketDto.setAmount("5");
				ticketDao.buyTicket(ticketDto);
			}
		});
	}

}
