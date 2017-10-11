
package cz.fio.api.client.pojo;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author rozkovec
 */
public class Transaction implements Serializable
{

	@SerializedName("column22")
	@Expose
	private IDPohybu idPohybu;

	@SerializedName("column0")
	@Expose
	private Datum datum;

	@SerializedName("column1")
	@Expose
	private Objem objem;

	@SerializedName("column14")
	@Expose
	private Mena mena;

	@SerializedName("column2")
	@Expose
	private Protiucet protiucet;

	@SerializedName("column10")
	@Expose
	private NazevProtiuctu nazevProtiuctu;

	@SerializedName("column3")
	@Expose
	private KodBanky kodBanky;

	@SerializedName("column12")
	@Expose
	private NazevBanky nazevBanky;

	@SerializedName("column4")
	@Expose
	private KonstantniSymbol konstantniSymbol;

	@SerializedName("column5")
	@Expose
	private VariabilniSymbol variabilniSymbol;

	@SerializedName("column6")
	@Expose
	private SpecifickySymbol specifickySymbol;

	@SerializedName("column7")
	@Expose
	private UzivatelskaIdentifikace uzivatelskaIdentifikace;

	@SerializedName("column16")
	@Expose
	private ZpravaProPrijemce zpravaProPrijemce;

	@SerializedName("column8")
	@Expose
	private TypPohybu typPohybu;

	@SerializedName("column9")
	@Expose
	private Provedl provedl;

	@SerializedName("column18")
	@Expose
	private Upresneni upresneni;

	@SerializedName("column25")
	@Expose
	private Komentar komentar;

	@SerializedName("column26")
	@Expose
	private BIC bic;

	@SerializedName("column17")
	@Expose
	private IDPokynu idPokynu;

	private final static long serialVersionUID = -1254148719445218134L;

	/**
	 * Construct.
	 */
	public Transaction()
	{
	}

	/**
	 * Gets idPohybu.
	 * 
	 * @return idPohybu
	 */
	public IDPohybu getIdPohybu()
	{
		return idPohybu;
	}

	/**
	 * Sets idPohybu.
	 * 
	 * @param idPohybu
	 *            idPohybu
	 */
	public void setIdPohybu(IDPohybu idPohybu)
	{
		this.idPohybu = idPohybu;
	}

	/**
	 * Gets datum.
	 * 
	 * @return datum
	 */
	public Datum getDatum()
	{
		return datum;
	}

	/**
	 * Sets datum.
	 * 
	 * @param datum
	 *            datum
	 */
	public void setDatum(Datum datum)
	{
		this.datum = datum;
	}

	/**
	 * Gets objem.
	 * 
	 * @return objem
	 */
	public Objem getObjem()
	{
		return objem;
	}

	/**
	 * Sets objem.
	 * 
	 * @param objem
	 *            objem
	 */
	public void setObjem(Objem objem)
	{
		this.objem = objem;
	}

	/**
	 * Gets mena.
	 * 
	 * @return mena
	 */
	public Mena getMena()
	{
		return mena;
	}

	/**
	 * Sets mena.
	 * 
	 * @param mena
	 *            mena
	 */
	public void setMena(Mena mena)
	{
		this.mena = mena;
	}

	/**
	 * Gets protiucet.
	 * 
	 * @return protiucet
	 */
	public Protiucet getProtiucet()
	{
		return protiucet;
	}

	/**
	 * Sets protiucet.
	 * 
	 * @param protiucet
	 *            protiucet
	 */
	public void setProtiucet(Protiucet protiucet)
	{
		this.protiucet = protiucet;
	}

	/**
	 * Gets nazevProtiuctu.
	 * 
	 * @return nazevProtiuctu
	 */
	public NazevProtiuctu getNazevProtiuctu()
	{
		return nazevProtiuctu;
	}

	/**
	 * Sets nazevProtiuctu.
	 * 
	 * @param nazevProtiuctu
	 *            nazevProtiuctu
	 */
	public void setNazevProtiuctu(NazevProtiuctu nazevProtiuctu)
	{
		this.nazevProtiuctu = nazevProtiuctu;
	}

	/**
	 * Gets kodBanky.
	 * 
	 * @return kodBanky
	 */
	public KodBanky getKodBanky()
	{
		return kodBanky;
	}

	/**
	 * Sets kodBanky.
	 * 
	 * @param kodBanky
	 *            kodBanky
	 */
	public void setKodBanky(KodBanky kodBanky)
	{
		this.kodBanky = kodBanky;
	}

	/**
	 * Gets nazevBanky.
	 * 
	 * @return nazevBanky
	 */
	public NazevBanky getNazevBanky()
	{
		return nazevBanky;
	}

	/**
	 * Sets nazevBanky.
	 * 
	 * @param nazevBanky
	 *            nazevBanky
	 */
	public void setNazevBanky(NazevBanky nazevBanky)
	{
		this.nazevBanky = nazevBanky;
	}

	/**
	 * Gets konstantniSymbol.
	 * 
	 * @return konstantniSymbol
	 */
	public KonstantniSymbol getKonstantniSymbol()
	{
		return konstantniSymbol;
	}

	/**
	 * Sets konstantniSymbol.
	 * 
	 * @param konstantniSymbol
	 *            konstantniSymbol
	 */
	public void setKonstantniSymbol(KonstantniSymbol konstantniSymbol)
	{
		this.konstantniSymbol = konstantniSymbol;
	}

	/**
	 * Gets variabilniSymbol.
	 * 
	 * @return variabilniSymbol
	 */
	public VariabilniSymbol getVariabilniSymbol()
	{
		return variabilniSymbol;
	}

	/**
	 * Sets variabilniSymbol.
	 * 
	 * @param variabilniSymbol
	 *            variabilniSymbol
	 */
	public void setVariabilniSymbol(VariabilniSymbol variabilniSymbol)
	{
		this.variabilniSymbol = variabilniSymbol;
	}

	/**
	 * Gets specifickySymbol.
	 * 
	 * @return specifickySymbol
	 */
	public SpecifickySymbol getSpecifickySymbol()
	{
		return specifickySymbol;
	}

	/**
	 * Sets specifickySymbol.
	 * 
	 * @param specifickySymbol
	 *            specifickySymbol
	 */
	public void setSpecifickySymbol(SpecifickySymbol specifickySymbol)
	{
		this.specifickySymbol = specifickySymbol;
	}

	/**
	 * Gets uzivatelskaIdentifikace.
	 * 
	 * @return uzivatelskaIdentifikace
	 */
	public UzivatelskaIdentifikace getUzivatelskaIdentifikace()
	{
		return uzivatelskaIdentifikace;
	}

	/**
	 * Sets uzivatelskaIdentifikace.
	 * 
	 * @param uzivatelskaIdentifikace
	 *            uzivatelskaIdentifikace
	 */
	public void setUzivatelskaIdentifikace(UzivatelskaIdentifikace uzivatelskaIdentifikace)
	{
		this.uzivatelskaIdentifikace = uzivatelskaIdentifikace;
	}

	/**
	 * Gets zpravaProPrijemce.
	 * 
	 * @return zpravaProPrijemce
	 */
	public ZpravaProPrijemce getZpravaProPrijemce()
	{
		return zpravaProPrijemce;
	}

	/**
	 * Sets zpravaProPrijemce.
	 * 
	 * @param zpravaProPrijemce
	 *            zpravaProPrijemce
	 */
	public void setZpravaProPrijemce(ZpravaProPrijemce zpravaProPrijemce)
	{
		this.zpravaProPrijemce = zpravaProPrijemce;
	}

	/**
	 * Gets typPohybu.
	 * 
	 * @return typPohybu
	 */
	public TypPohybu getTypPohybu()
	{
		return typPohybu;
	}

	/**
	 * Sets typPohybu.
	 * 
	 * @param typPohybu
	 *            typPohybu
	 */
	public void setTypPohybu(TypPohybu typPohybu)
	{
		this.typPohybu = typPohybu;
	}

	/**
	 * Gets provedl.
	 * 
	 * @return provedl
	 */
	public Provedl getProvedl()
	{
		return provedl;
	}

	/**
	 * Sets provedl.
	 * 
	 * @param provedl
	 *            provedl
	 */
	public void setProvedl(Provedl provedl)
	{
		this.provedl = provedl;
	}

	/**
	 * Gets upresneni.
	 * 
	 * @return upresneni
	 */
	public Upresneni getUpresneni()
	{
		return upresneni;
	}

	/**
	 * Sets upresneni.
	 * 
	 * @param upresneni
	 *            upresneni
	 */
	public void setUpresneni(Upresneni upresneni)
	{
		this.upresneni = upresneni;
	}

	/**
	 * Gets komentar.
	 * 
	 * @return komentar
	 */
	public Komentar getKomentar()
	{
		return komentar;
	}

	/**
	 * Sets komentar.
	 * 
	 * @param komentar
	 *            komentar
	 */
	public void setKomentar(Komentar komentar)
	{
		this.komentar = komentar;
	}

	/**
	 * Gets bic.
	 * 
	 * @return bic
	 */
	public BIC getBic()
	{
		return bic;
	}

	/**
	 * Sets bic.
	 * 
	 * @param bic
	 *            bic
	 */
	public void setBic(BIC bic)
	{
		this.bic = bic;
	}

	/**
	 * Gets idPokynu.
	 * 
	 * @return idPokynu
	 */
	public IDPokynu getIdPokynu()
	{
		return idPokynu;
	}

	/**
	 * Sets idPokynu.
	 * 
	 * @param idPokynu
	 *            idPokynu
	 */
	public void setIdPokynu(IDPokynu idPokynu)
	{
		this.idPokynu = idPokynu;
	}

}
