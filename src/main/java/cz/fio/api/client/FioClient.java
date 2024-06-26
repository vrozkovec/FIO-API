package cz.fio.api.client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import cz.fio.api.client.FioConstants.AnswerFormat;
import cz.fio.api.client.FioConstants.Languages;
import cz.fio.api.client.FioConstants.OrderFormat;
import cz.fio.api.client.https.BasicHttpsConnector;
import cz.fio.api.client.https.HttpsConnector;
import cz.fio.api.client.https.HttpsRequestException;
import cz.fio.api.client.result.FioResult;

public class FioClient
{
	private static final String HTTPS_WWW_FIO_CZ = "https://fioapi.fio.cz/v1/rest/";
	// by-id/{token}/{year}/{id}/transactions.{format}
	private static final String GET_STATEMENTS = "%sby-id/%s/%s/%s/transactions.%s";
	// periods/{token}/{datum od}/{datum do}/transactions.{format}
	private static final String GET_TRANSACTIONS = "%speriods/%s/%s/%s/transactions.%s";
	// last/{token}/transactions.{format}
	private static final String GET_NEW_TRANSACTIONS = "%slast/%s/transactions.%s";
	// set-last-id/{token}/{id}/
	private static final String SET_LAST_BY_ID = "%sset-last-id/%s/%s/";
	// set-last-date/{token}/{rrrr-mm-dd}/
	private static final String SET_LAST_BY_DATE = "%sset-last-date/%s/%s/";
	// import/
	private static final String SEND_ORDER = "%s/import/";

	private String token = "";
	private AnswerFormat answerFormat = AnswerFormat.xml;
	private String fioUrl = HTTPS_WWW_FIO_CZ;

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private HttpsConnector httpConnector;
	private Languages answerLanguage = Languages.cs;

	public FioClient(String token, AnswerFormat answerFormat)
	{
		this.token = token;
		this.answerFormat = answerFormat;
		setHttpConnector(new BasicHttpsConnector());
	}

	public FioResult getTransactions(LocalDate from, LocalDate to) throws InvalidParametersException, HttpsRequestException
	{
		if (from == null || to == null || from.isAfter(to))
		{
			throw new InvalidParametersException("From, To can't be null, and From can't be after To");
		}

		String url = String.format(GET_TRANSACTIONS, fioUrl, getToken(), dateFormatter.format(from),
			dateFormatter.format(to), getAnswerFormat().toString());
		return executeRequest(url);
	}

	public FioResult getNewTransactions() throws HttpsRequestException
	{
		String url = String.format(GET_NEW_TRANSACTIONS, fioUrl, getToken(), getAnswerFormat().toString());
		return executeRequest(url);
	}

	public FioResult getStatement(int year, int statementNumber) throws HttpsRequestException
	{
		String url = String.format(GET_STATEMENTS, fioUrl, getToken(), String.valueOf(year),
			String.valueOf(statementNumber), getAnswerFormat().toString());
		return executeRequest(url);
	}

	public FioResult setTransactionPointerByDate(LocalDate date) throws HttpsRequestException, InvalidParametersException
	{
		if (date == null)
		{
			throw new InvalidParametersException("Date can't be null");
		}
		String url = String.format(SET_LAST_BY_DATE, fioUrl, getToken(), dateFormatter.format(date),
			getAnswerFormat().toString());
		return executeRequest(url);
	}

	public FioResult setTransactionPointerById(int pointer) throws HttpsRequestException
	{
		String url = String.format(SET_LAST_BY_ID, fioUrl, getToken(), String.valueOf(pointer),
			getAnswerFormat().toString());
		return executeRequest(url);
	}

	private FioResult executeRequest(String url) throws HttpsRequestException
	{
		byte[] result = httpConnector.getData(url);
		return new FioResult(result, getAnswerFormat(), url);
	}

	public HttpsConnector getHttpConnector()
	{
		return httpConnector;
	}

	public void setHttpConnector(HttpsConnector connector)
	{
		this.httpConnector = connector;
	}

	public String getUrl()
	{
		return fioUrl;
	}

	public void setUrl(String url)
	{
		this.fioUrl = url;
	}

	public AnswerFormat getAnswerFormat()
	{
		return answerFormat;
	}

	public void setAnswerFormat(AnswerFormat dataFormat)
	{
		this.answerFormat = dataFormat;

	}

	public String getToken()
	{
		return this.token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	/**
	 * @param order
	 * @param format
	 * @return
	 * @throws HttpsRequestException
	 * @throws InvalidParametersException
	 */
	public FioResult sendOrder(String order, OrderFormat format) throws HttpsRequestException, InvalidParametersException
	{
		if (order == null || format == null)
		{
			throw new InvalidParametersException("Parameters can't be null");
		}
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("lng", answerLanguage.toString());
		parameters.put("token", token);
		parameters.put("type", format.toString());
		parameters.put("file", order);
		parameters.put("filename", "SomeName");

		byte[] response = httpConnector.getPostData(String.format(SEND_ORDER, fioUrl), parameters);
		return new FioResult(response, AnswerFormat.xml, String.format(SEND_ORDER, fioUrl));
	}

	/**
	 * Vrati jazyk pouzity pro odpoved banky na platebni prikaz
	 * 
	 * @return
	 */
	public Languages getAnswerLanguage()
	{
		return answerLanguage;
	}

	/**
	 * Nastav jazyk popisku pri odpovedi banky. Pouziva se jenom pro odpovedi platebnich prikazu
	 * 
	 * @param language
	 */
	public void setAnswerLanguage(Languages language)
	{
		answerLanguage = language;
	}

}
