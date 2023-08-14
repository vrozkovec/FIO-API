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
package cz.fio.api.util.pojo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cz.fio.api.client.pojo.Transaction;
import cz.fio.api.util.FioUtil;

/**
 * This domain object contains flatenned response for ease of use.
 * 
 * @author rozkovec
 */
public class PohybNaUctu
{
	public static final Locale locale = new Locale("cs", "CZ");

	private long idPohybu;

	private Date datum;

	private BigDecimal castka;
	private String mena;
	private String protiucet;
	private String protiucetNazev;
	private String bankaKod;
	private String bankaNazev;
	private String symbolKonstantni;
	private String symbolVariabilni;
	private String symbolSpecificky;
	private String uzivatelskaIdentifikace;
	private String zpravaProPrijemce;
	private String typPohybu;
	private String provedl;
	private String upresneni;
	private String komentar;
	private String bic;
	private Long idPokynu;

	/***************************************************
	 * UTILITY METHODS
	 ****************************************************/

	/**
	 * @param t
	 * @return instance of {@link PohybNaUctu}
	 */
	public static PohybNaUctu createFrom(Transaction t)
	{
		PohybNaUctu pohyb = new PohybNaUctu();
		pohyb.idPohybu = getOrNull(t.getIdPohybu());
		// 2017-01-10+0100
		String target = getOrNull(t.getDatum());
		DateFormat df = new SimpleDateFormat("yyyy-MM-ddZ", locale);

		try
		{
			pohyb.datum = df.parse(target);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		pohyb.castka = BigDecimal.valueOf(t.getObjem().getValue());
		pohyb.mena = getOrNull(t.getMena());
		pohyb.protiucet = getOrNull(t.getProtiucet());
		pohyb.protiucetNazev = getOrNull(t.getNazevProtiuctu());
		pohyb.bankaKod = getOrNull(t.getKodBanky());
		pohyb.bankaNazev = getOrNull(t.getNazevBanky());
		pohyb.symbolKonstantni = getOrNull(t.getKonstantniSymbol());
		pohyb.symbolVariabilni = getOrNull(t.getVariabilniSymbol());
		pohyb.symbolSpecificky = getOrNull(t.getSpecifickySymbol());
		pohyb.uzivatelskaIdentifikace = getOrNull(t.getUzivatelskaIdentifikace());
		pohyb.zpravaProPrijemce = getOrNull(t.getZpravaProPrijemce());
		pohyb.typPohybu = getOrNull(t.getTypPohybu());
		pohyb.provedl = getOrNull(t.getProvedl());
		pohyb.upresneni = getOrNull(t.getUpresneni());
		pohyb.komentar = getOrNull(t.getKomentar());
		pohyb.bic = getOrNull(t.getBic());
		pohyb.idPokynu = getOrNull(t.getIdPokynu());

		return pohyb;
	}

	private static <T> T getOrNull(IValue<T> value)
	{
		if (value != null)
			return value.getValue();

		return null;
	}

	/***************************************************
	 * GETTERS / SETTERS
	 ****************************************************/

	/**
	 * Gets idPohybu.
	 *
	 * @return idPohybu
	 */
	public long getIdPohybu()
	{
		return idPohybu;
	}

	/**
	 * Sets idPohybu.
	 *
	 * @param idPohybu
	 *            idPohybu
	 */
	public void setIdPohybu(long idPohybu)
	{
		this.idPohybu = idPohybu;
	}

	/**
	 * Gets datum.
	 *
	 * @return datum
	 */
	public Date getDatum()
	{
		return datum;
	}

	/**
	 * Sets datum.
	 *
	 * @param datum
	 *            datum
	 */
	public void setDatum(Date datum)
	{
		this.datum = datum;
	}

	/**
	 * Gets castka.
	 *
	 * @return castka
	 */
	public BigDecimal getCastka()
	{
		return castka;
	}

	/**
	 * Sets castka.
	 *
	 * @param castka
	 *            castka
	 */
	public void setCastka(BigDecimal castka)
	{
		this.castka = castka;
	}

	/**
	 * Gets mena.
	 *
	 * @return mena
	 */
	public String getMena()
	{
		return mena;
	}

	/**
	 * Sets mena.
	 *
	 * @param mena
	 *            mena
	 */
	public void setMena(String mena)
	{
		this.mena = mena;
	}

	/**
	 * Gets protiucet.
	 *
	 * @return protiucet
	 */
	public String getProtiucet()
	{
		return protiucet;
	}

	/**
	 * Sets protiucet.
	 *
	 * @param protiucet
	 *            protiucet
	 */
	public void setProtiucet(String protiucet)
	{
		this.protiucet = protiucet;
	}

	/**
	 * Gets protiucetNazev.
	 *
	 * @return protiucetNazev
	 */
	public String getProtiucetNazev()
	{
		return protiucetNazev;
	}

	/**
	 * Sets protiucetNazev.
	 *
	 * @param protiucetNazev
	 *            protiucetNazev
	 */
	public void setProtiucetNazev(String protiucetNazev)
	{
		this.protiucetNazev = protiucetNazev;
	}

	/**
	 * Gets bankaKod.
	 *
	 * @return bankaKod
	 */
	public String getBankaKod()
	{
		return bankaKod;
	}

	/**
	 * Sets bankaKod.
	 *
	 * @param bankaKod
	 *            bankaKod
	 */
	public void setBankaKod(String bankaKod)
	{
		this.bankaKod = bankaKod;
	}

	/**
	 * Gets bankaNazev.
	 *
	 * @return bankaNazev
	 */
	public String getBankaNazev()
	{
		return bankaNazev;
	}

	/**
	 * Sets bankaNazev.
	 *
	 * @param bankaNazev
	 *            bankaNazev
	 */
	public void setBankaNazev(String bankaNazev)
	{
		this.bankaNazev = bankaNazev;
	}

	/**
	 * Gets symbolKonstantni.
	 *
	 * @return symbolKonstantni
	 */
	public String getSymbolKonstantni()
	{
		return symbolKonstantni;
	}

	/**
	 * Sets symbolKonstantni.
	 *
	 * @param symbolKonstantni
	 *            symbolKonstantni
	 */
	public void setSymbolKonstantni(String symbolKonstantni)
	{
		this.symbolKonstantni = symbolKonstantni;
	}

	/**
	 * Gets symbolVariabilni.
	 *
	 * @return symbolVariabilni
	 */
	public String getSymbolVariabilni()
	{
		return symbolVariabilni;
	}

	/**
	 * Sets symbolVariabilni.
	 *
	 * @param symbolVariabilni
	 *            symbolVariabilni
	 */
	public void setSymbolVariabilni(String symbolVariabilni)
	{
		this.symbolVariabilni = symbolVariabilni;
	}

	/**
	 * Gets symbolSpecificky.
	 *
	 * @return symbolSpecificky
	 */
	public String getSymbolSpecificky()
	{
		return symbolSpecificky;
	}

	/**
	 * Sets symbolSpecificky.
	 *
	 * @param symbolSpecificky
	 *            symbolSpecificky
	 */
	public void setSymbolSpecificky(String symbolSpecificky)
	{
		this.symbolSpecificky = symbolSpecificky;
	}

	/**
	 * Gets uzivatelskaIdentifikace.
	 *
	 * @return uzivatelskaIdentifikace
	 */
	public String getUzivatelskaIdentifikace()
	{
		return uzivatelskaIdentifikace;
	}

	/**
	 * Sets uzivatelskaIdentifikace.
	 *
	 * @param uzivatelskaIdentifikace
	 *            uzivatelskaIdentifikace
	 */
	public void setUzivatelskaIdentifikace(String uzivatelskaIdentifikace)
	{
		this.uzivatelskaIdentifikace = uzivatelskaIdentifikace;
	}

	/**
	 * Gets zpravaProPrijemce.
	 *
	 * @return zpravaProPrijemce
	 */
	public String getZpravaProPrijemce()
	{
		return zpravaProPrijemce;
	}

	/**
	 * Sets zpravaProPrijemce.
	 *
	 * @param zpravaProPrijemce
	 *            zpravaProPrijemce
	 */
	public void setZpravaProPrijemce(String zpravaProPrijemce)
	{
		this.zpravaProPrijemce = zpravaProPrijemce;
	}

	/**
	 * Gets typPohybu.
	 *
	 * @return typPohybu
	 */
	public String getTypPohybu()
	{
		return typPohybu;
	}

	/**
	 * Sets typPohybu.
	 *
	 * @param typPohybu
	 *            typPohybu
	 */
	public void setTypPohybu(String typPohybu)
	{
		this.typPohybu = typPohybu;
	}

	/**
	 * Gets provedl.
	 *
	 * @return provedl
	 */
	public String getProvedl()
	{
		return provedl;
	}

	/**
	 * Sets provedl.
	 *
	 * @param provedl
	 *            provedl
	 */
	public void setProvedl(String provedl)
	{
		this.provedl = provedl;
	}

	/**
	 * Gets upresneni.
	 *
	 * @return upresneni
	 */
	public String getUpresneni()
	{
		return upresneni;
	}

	/**
	 * Sets upresneni.
	 *
	 * @param upresneni
	 *            upresneni
	 */
	public void setUpresneni(String upresneni)
	{
		this.upresneni = upresneni;
	}

	/**
	 * Gets komentar.
	 *
	 * @return komentar
	 */
	public String getKomentar()
	{
		return komentar;
	}

	/**
	 * Sets komentar.
	 *
	 * @param komentar
	 *            komentar
	 */
	public void setKomentar(String komentar)
	{
		this.komentar = komentar;
	}

	/**
	 * Gets bic.
	 *
	 * @return bic
	 */
	public String getBic()
	{
		return bic;
	}

	/**
	 * Sets bic.
	 *
	 * @param bic
	 *            bic
	 */
	public void setBic(String bic)
	{
		this.bic = bic;
	}

	/**
	 * Gets idPokynu.
	 *
	 * @return idPokynu
	 */
	public Long getIdPokynu()
	{
		return idPokynu;
	}

	/**
	 * Sets idPokynu.
	 *
	 * @param idPokynu
	 *            idPokynu
	 */
	public void setIdPokynu(Long idPokynu)
	{
		this.idPokynu = idPokynu;
	}

}
