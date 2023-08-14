package cz.fio.api.client;

import java.time.LocalDate;
import java.util.Calendar;

import org.testng.annotations.Test;

import cz.fio.api.client.FioClient;
import cz.fio.api.client.FioConstants;
import cz.fio.api.client.InvalidParametersException;
import cz.fio.api.client.https.HttpsRequestException;
import cz.fio.api.client.result.FioResult;

public class FioClientRealServerTest
{

	@Test(groups = { "Real" })
	public void getDateRangeTransactions() throws InvalidParametersException, HttpsRequestException
	{
		String token = System.getenv("TOKEN");
		FioClient fc = new FioClient(token, FioConstants.AnswerFormat.json);
		LocalDate from = LocalDate.of(2013, 6, 15);
		LocalDate to = LocalDate.of(2013, 6, 18);
		FioResult fr = fc.getTransactions(from, to);
		System.out.println(fr.getResponseAsText());
	}
}
