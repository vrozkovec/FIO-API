/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.fio.api.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;

import cz.fio.api.client.FioClient;
import cz.fio.api.client.FioConstants.AnswerFormat;
import cz.fio.api.client.InvalidParametersException;
import cz.fio.api.client.https.HttpsRequestException;
import cz.fio.api.client.pojo.FioTransactions;
import cz.fio.api.client.pojo.Transaction;
import cz.fio.api.client.result.FioResult;
import cz.fio.api.util.pojo.PohybNaUctu;

/**
 * @author vit
 */
public class FioUtil
{
	public static final Locale locale = new Locale("cs", "CZ");

	/**
	 * Checks for account movements
	 *
	 * @param token
	 * @return list of account movements
	 */
	public static List<PohybNaUctu> getPohybyNaUctu(String token)
	{
		FioClient client = new FioClient(token, AnswerFormat.json);

		System.err.println(" << Checking account >> token: " + token.substring(0, 5) + "...");
		try
		{
			FioResult transactions = client.getNewTransactions();
			String json = transactions.getResponseAsText();
			/*
			 * String json =
			 * "{'accountStatement':{'info':{'accountId':'2801061910','bankId':'2010','currency':'CZK','iban':'CZ2720100000002801061910','bic':'FIOBCZPPXXX','openingBalance':0.00,'closingBalance':18113.40,'dateStart':'1900-01-01+0100','dateEnd':'2017-02-01+0100','yearList':null,'idList':null,'idFrom':13873331014,'idTo':13880041707,'idLastDownload':null},'transactionList':{'transaction':[{'column22':{'value':13873331014,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-02+0100','name':'Datum','id':0},'column1':{'value':1000.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'2423481001','name':'Protiúčet','id':2},'column10':{'value':'Alžběta Smith Kigand','name':'Název protiúčtu','id':10},'column3':{'value':'5500','name':'Kód banky','id':3},'column12':{'value':'Raiffeisenbank a.s.','name':'Název banky','id':12},'column4':{'value':'0000','name':'KS','id':4},'column5':{'value':'201600245','name':'VS','id':5},'column6':null,'column7':{'value':'Alžběta Smith Kigand','name':'Uživatelská identifikace','id':7},'column16':{'value':'mint ubuntu','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní příjem','name':'Typ','id':8},'column9':null,'column18':null,'column25':{'value':'NT201600245 Alžběta Smith Kigand','name':'Komentář','id':25},'column26':null,'column17':{'value':15458985677,'name':'ID pokynu','id':17}},{'column22':{'value':13873506584,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-02+0100','name':'Datum','id':0},'column1':{'value':-7663.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'107-6637510267','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':{'value':'0308','name':'KS','id':4},'column5':{'value':'20160797','name':'VS','id':5},'column6':null,'column7':{'value':'FA 20160797 Voice of Prague','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 20160797 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 20160797 Voice of Prague','name':'Komentář','id':25},'column26':null,'column17':{'value':15460090413,'name':'ID pokynu','id':17}},{'column22':{'value':13874108342,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-03+0100','name':'Datum','id':0},'column1':{'value':-422.03,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'19747171','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':{'value':'0308','name':'KS','id':4},'column5':{'value':'20170101','name':'VS','id':5},'column6':null,'column7':{'value':'FA 20170101 Dunka preklad webu','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 20170101 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 20170101 Dunka preklad webu','name':'Komentář','id':25},'column26':null,'column17':{'value':15462911856,'name':'ID pokynu','id':17}},{'column22':{'value':13874118223,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-03+0100','name':'Datum','id':0},'column1':{'value':-1770.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'3259214001','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'5500','name':'Kód banky','id':3},'column12':{'value':'Raiffeisenbank a.s.','name':'Název banky','id':12},'column4':null,'column5':{'value':'3941','name':'VS','id':5},'column6':null,'column7':{'value':'FA 3400 netprint barva','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 3400 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 3400 netprint barva','name':'Komentář','id':25},'column26':null,'column17':{'value':15462957730,'name':'ID pokynu','id':17}},{'column22':{'value':13874199676,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-03+0100','name':'Datum','id':0},'column1':{'value':-2283.81,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':null,'column10':null,'column3':null,'column12':null,'column4':null,'column5':{'value':'5878','name':'VS','id':5},'column6':null,'column7':{'value':'Nákup: FACEBK 56TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  2283.81 CZK','name':'Uživatelská identifikace','id':7},'column16':{'value':'Nákup: FACEBK 56TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  2283.81 CZK','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Platba kartou','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'Nákup: FACEBK 56TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  2283.81 CZK','name':'Komentář','id':25},'column26':null,'column17':{'value':15463231269,'name':'ID pokynu','id':17}},{'column22':{'value':13874199678,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-03+0100','name':'Datum','id':0},'column1':{'value':-70.42,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':null,'column10':null,'column3':null,'column12':null,'column4':null,'column5':{'value':'5878','name':'VS','id':5},'column6':null,'column7':{'value':'Nákup: FACEBK 66TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  70.42 CZK','name':'Uživatelská identifikace','id':7},'column16':{'value':'Nákup: FACEBK 66TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  70.42 CZK','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Platba kartou','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'Nákup: FACEBK 66TVBB2VS2, www.fb.me/ads, IR, dne 31.12.2016, částka  70.42 CZK','name':'Komentář','id':25},'column26':null,'column17':{'value':15463231271,'name':'ID pokynu','id':17}},{'column22':{'value':13875044490,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-05+0100','name':'Datum','id':0},'column1':{'value':-615.89,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'4309711319','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0800','name':'Kód banky','id':3},'column12':{'value':'Česká spořitelna, a.s.','name':'Název banky','id':12},'column4':null,'column5':{'value':'2117001993','name':'VS','id':5},'column6':null,'column7':{'value':'FA 2117001993 Printuj.cz vizitky Mili','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 2117001993 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 2117001993 Printuj.cz vizitky Mili','name':'Komentář','id':25},'column26':null,'column17':{'value':15467079353,'name':'ID pokynu','id':17}},{'column22':{'value':13875047205,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-05+0100','name':'Datum','id':0},'column1':{'value':-1360.04,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'224645051','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':{'value':'0308','name':'KS','id':4},'column5':{'value':'1282016','name':'VS','id':5},'column6':null,'column7':{'value':'FA 1282016 Clarino','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 1282016 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 1282016 Clarino','name':'Komentář','id':25},'column26':null,'column17':{'value':15467090433,'name':'ID pokynu','id':17}},{'column22':{'value':13875093364,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-05+0100','name':'Datum','id':0},'column1':{'value':-535.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':null,'column10':null,'column3':null,'column12':null,'column4':null,'column5':{'value':'6808','name':'VS','id':5},'column6':null,'column7':{'value':'Nákup: TOMADOS S.R.O., PRAHA 8, CZ, dne 3.1.2017, částka  535.00 CZK','name':'Uživatelská identifikace','id':7},'column16':{'value':'Nákup: TOMADOS S.R.O., PRAHA 8, CZ, dne 3.1.2017, částka  535.00 CZK','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Platba kartou','name':'Typ','id':8},'column9':{'value':'Goz, Omri','name':'Provedl','id':9},'column18':null,'column25':{'value':'Nákup: TOMADOS S.R.O., PRAHA 8, CZ, dne 3.1.2017, částka  535.00 CZK','name':'Komentář','id':25},'column26':null,'column17':{'value':15467286667,'name':'ID pokynu','id':17}},{'column22':{'value':13875282629,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-05+0100','name':'Datum','id':0},'column1':{'value':-18150.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'2000742564','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'2010','name':'Kód banky','id':3},'column12':{'value':'Fio banka, a.s.','name':'Název banky','id':12},'column4':null,'column5':{'value':'201668','name':'VS','id':5},'column6':null,'column7':{'value':'FA 201668 Prest','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 201668 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Platba převodem uvnitř banky','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 201668 Prest','name':'Komentář','id':25},'column26':null,'column17':{'value':15468185701,'name':'ID pokynu','id':17}},{'column22':{'value':13875284369,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-05+0100','name':'Datum','id':0},'column1':{'value':-7350.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'239698762','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0300','name':'Kód banky','id':3},'column12':{'value':'ČSOB, a.s.','name':'Název banky','id':12},'column4':null,'column5':{'value':'2017001','name':'VS','id':5},'column6':null,'column7':{'value':'FA 2017001 Petr Belak Weekend Market grafika','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 2017001 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 2017001 Petr Belak Weekend Market grafika','name':'Komentář','id':25},'column26':null,'column17':{'value':15468195791,'name':'ID pokynu','id':17}},{'column22':{'value':13876302229,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-09+0100','name':'Datum','id':0},'column1':{'value':-553.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'180801111','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':{'value':'0308','name':'KS','id':4},'column5':{'value':'1701000071','name':'VS','id':5},'column6':null,'column7':{'value':'FA 1701000071 Tomados, tisk prezentaci','name':'Uživatelská identifikace','id':7},'column16':{'value':'FA 1701000071 Nové trhy, z.s.','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'FA 1701000071 Tomados, tisk prezentaci','name':'Komentář','id':25},'column26':null,'column17':{'value':15472675934,'name':'ID pokynu','id':17}},{'column22':{'value':13876740281,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-10+0100','name':'Datum','id':0},'column1':{'value':8700.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'35-6750410217','name':'Protiúčet','id':2},'column10':{'value':'SPOLEČENSTVÍ VLASTNÍ','name':'Název protiúčtu','id':10},'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':{'value':'0000','name':'KS','id':4},'column5':{'value':'2016004','name':'VS','id':5},'column6':{'value':'0','name':'SS','id':6},'column7':{'value':'SPOLEČENSTVÍ VLASTNÍ','name':'Uživatelská identifikace','id':7},'column16':{'value':'KREJČOVSTVÍ KUBCOVÁ-UNIFORMY  KREJČOVSTVÍ KUBCOVÁ-UNIFORMY','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní příjem','name':'Typ','id':8},'column9':null,'column18':null,'column25':{'value':'SPOLEČENSTVÍ VLASTNÍ','name':'Komentář','id':25},'column26':null,'column17':{'value':15474751653,'name':'ID pokynu','id':17}},{'column22':{'value':13878295041,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-12+0100','name':'Datum','id':0},'column1':{'value':-8700.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'35-6750410217','name':'Protiúčet','id':2},'column10':null,'column3':{'value':'0100','name':'Kód banky','id':3},'column12':{'value':'Komerční banka a.s.','name':'Název banky','id':12},'column4':null,'column5':null,'column6':null,'column7':{'value':'Vrácení špatně zadané platby','name':'Uživatelská identifikace','id':7},'column16':{'value':'Vrácení špatně zadané platby','name':'Zpráva pro příjemce','id':16},'column8':{'value':'Bezhotovostní platba','name':'Typ','id':8},'column9':{'value':'Kolářová, Lenka','name':'Provedl','id':9},'column18':null,'column25':{'value':'Vrácení špatně zadané platby','name':'Komentář','id':25},'column26':null,'column17':{'value':15481699584,'name':'ID pokynu','id':17}},{'column22':{'value':13880041707,'name':'ID pohybu','id':22},'column0':{'value':'2017-01-16+0100','name':'Datum','id':0},'column1':{'value':1000.00,'name':'Objem','id':1},'column14':{'value':'CZK','name':'Měna','id':14},'column2':{'value':'208200730','name':'Protiúčet','id':2},'column10':{'value':'BLESKOVÁ EVA','name':'Název protiúčtu','id':10},'column3':{'value':'0600','name':'Kód banky','id':3},'column12':{'value':'MONETA Money Bank, a.s.','name':'Název banky','id':12},'column4':null,'column5':{'value':'201600259','name':'VS','id':5},'column6':null,'column7':{'value':'BLESKOVÁ EVA','name':'Uživatelská identifikace','id':7},'column16':null,'column8':{'value':'Bezhotovostní příjem','name':'Typ','id':8},'column9':null,'column18':null,'column25':{'value':'NT201600259 BLESKOVÁ EVA','name':'Komentář','id':25},'column26':null,'column17':{'value':15489366358,'name':'ID pokynu','id':17}}]}}}"
			 * ;
			 */
			FioTransactions statement = new Gson().fromJson(json, FioTransactions.class);

			List<Transaction> transactionRecords = statement.getAccountStatement().getTransactionList().getTransaction();

			ArrayList<PohybNaUctu> pohyby = new ArrayList<PohybNaUctu>();
			for (Transaction transaction : transactionRecords)
			{
				pohyby.add(PohybNaUctu.createFrom(transaction));
			}
			return pohyby;

		}
		catch (HttpsRequestException e)
		{
			throw new RuntimeException(e);
		}

	}

	/**
	 * Resets pointer to the start of the year
	 *
	 * @param token
	 */
	public static void setPointerToTheStartOfTheYear(String token)
	{
		FioClient client = new FioClient(token, AnswerFormat.json);

		try
		{
			Calendar calendar = Calendar.getInstance(locale);
			setMinimums(calendar, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE,
				Calendar.SECOND, Calendar.MILLISECOND);
			client.setTransactionPointerByDate(calendar);
			System.err.println("<<<<POINTER TO THE YEAR BEGINNING SET>>>>");
		}
		catch (HttpsRequestException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvalidParametersException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Nastavi dana pole na jejich aktualni minumum.
	 *
	 * @param calendar
	 * @param fields
	 */
	private static void setMinimums(Calendar calendar, int... fields)
	{
		for (int i : fields)
		{
			calendar.set(i, calendar.getActualMinimum(i));
		}

	}
}
