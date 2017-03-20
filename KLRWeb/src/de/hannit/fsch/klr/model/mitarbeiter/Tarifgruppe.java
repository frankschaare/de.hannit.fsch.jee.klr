/**
 * 
 */
package de.hannit.fsch.klr.model.mitarbeiter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

import de.hannit.fsch.common.AppConstants;

/**
 * @author fsch
 *
 */
public class Tarifgruppe
{
private String tarifGruppe = null;
private LocalDate berichtsMonat = null;
private BigDecimal summeTarifgruppe = null;
private double summeStellen = 0;
private double vollzeitAequivalent = 0;

	/**
	 * 
	 */
	public Tarifgruppe()
	{
	}

	public double getVollzeitAequivalent()
	{
		if (summeTarifgruppe.doubleValue() > 0 && summeStellen > 0)
		{
		//sumStellen = (summeStellen < 1) ? 1 : summeStellen;	
		vollzeitAequivalent = summeTarifgruppe.doubleValue() / summeStellen;
		}
		
	return vollzeitAequivalent;
	}
	
	public String getFormattedVollzeitAequivalent()
	{
	return NumberFormat.getCurrencyInstance().format((getVollzeitAequivalent()));
	}	

	public String getTarifGruppe(){	return tarifGruppe;}

	public void setTarifGruppe(String tarifGruppe)
	{
		this.tarifGruppe = tarifGruppe;
	}

	public LocalDate getBerichtsMonat()
	{
	return berichtsMonat;
	}

	public void setBerichtsMonat(LocalDate berichtsMonat)
	{
	this.berichtsMonat = berichtsMonat;
	}

	public BigDecimal getSummeTarifgruppe()
	{
	return summeTarifgruppe;
	}

	public String getFormattedSummeTarifgruppe()
	{
	return NumberFormat.getCurrencyInstance().format((getSummeTarifgruppe()));
	}

	public void addSummeTarifgruppe(BigDecimal toAdd)
	{
	this.summeTarifgruppe = summeTarifgruppe.add(toAdd);
	}
	
	public void setSummeTarifgruppe(BigDecimal summeTarifgruppe)
	{
	this.summeTarifgruppe = summeTarifgruppe;
	}

	public double getSummeStellen()
	{
		return summeStellen;
	}
	
	public String getFormattedSummeStellen()
	{
	return AppConstants.KOMMAZAHL.format((getSummeStellen()));
	}

	public void addSummeStellen(double toAdd)
	{
	this.summeStellen += toAdd;
	}
	
	public void setSummeStellen(double summeStellen)
	{
		this.summeStellen = summeStellen;
	}

}
