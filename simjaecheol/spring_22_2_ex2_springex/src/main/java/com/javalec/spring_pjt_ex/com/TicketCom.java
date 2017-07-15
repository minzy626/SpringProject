package com.javalec.spring_pjt_ex.com;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.javalec.spring_pjt_ex.dao.TicketDao;
import com.javalec.spring_pjt_ex.dto.TicketDto;

public class TicketCom implements ITicketCom {
	
	TicketDao ticketDao;
	TransactionTemplate transactionTemplate1;
	
	
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}



	public void setTransactionTemplate1(TransactionTemplate transactionTemplate1) {
		this.transactionTemplate1 = transactionTemplate1;
	}



	@Override
	public void execute(final TicketDto ticketDto) {
		
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				ticketDto.setAmount("1");
				ticketDao.buyTicket(ticketDto);
				
				ticketDto.setAmount("5");
				ticketDao.buyTicket(ticketDto);
				
			}
		});
		
	}

}
