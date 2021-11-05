package br.com.rconsultancy.util;

import java.math.BigDecimal;

public abstract class Document {

	public static BigDecimal valueStringToValueBigDecimal(String paramValue) {
		return new BigDecimal(paramValue.replace("R$", "").replace(",", ""));
	}
}
