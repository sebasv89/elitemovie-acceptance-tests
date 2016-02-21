package co.com.psl.elitemovie.ui.action;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.com.psl.elitemovie.ui.page.ConfirmationPage;

public class ConfirmationPageBehavior {
	
	private WebDriver _webDriver; 
	
	public ConfirmationPageBehavior(WebDriver driver) {
		_webDriver = driver;
	}

	ConfirmationPage _confirmationPage;
	
	
	public boolean verifyReservationMessage()
	{
		getPage().getSussesMessage();
		return true;
	}
	
	public String getReservationMessage()
	{
		return getPage().getSussesMessage();
	}
	
	public String formatReservationMessage(List<String> seatsToVerify)
	{
		String message = formatSucessMessage(seatsToVerify);
		return message;
	}
	
	private String formatSucessMessage(List<String> seatsToVerify) 
	{
		StringBuilder message = new StringBuilder();
		
		if(seatsToVerify.size() > 1)
		{
			message.append("Las sillas");
		}
		else
		{
			message.append("La silla");
		}
		
		int seatIndex = 0;
		for(String seat : seatsToVerify)
		{
			seatIndex++;
			String[] rowColumn = seat.split(",");
			message.append(" Fila:");
			message.append(rowColumn[0]);
			message.append("-");
			message.append("Columna:");
			message.append(rowColumn[1]);
			
			if(seatsToVerify.size() > 1 && seatIndex == seatsToVerify.size() - 1)
			{
				message.append(" y");
			}
			else if(seatIndex != seatsToVerify.size())
			{
				message.append(" ,");
			}
		}
		
		if(seatsToVerify.size() == 1)
		{	
		message.append(" h sido asignada correctamente!");
		}
		else
		{
			message.append(" han sido asignadas correctamente!");
		}
		return message.toString();
	}

	public void endReservation()
	{
		
		getPage().getEndButton().click();
	}

	public ConfirmationPage getPage()
	{
		if (_confirmationPage == null)
		{
			_confirmationPage = new ConfirmationPage(_webDriver);
		}
		return _confirmationPage;
	}
}
