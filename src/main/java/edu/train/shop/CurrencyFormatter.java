package edu.train.shop;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CurrencyFormatter implements Formatter<BigDecimal> {

  @Override
  public String print(BigDecimal object, Locale locale) {
    return getNumberFormat(locale).format(object);
  }

  @Override
  public BigDecimal parse(String text, Locale locale) throws ParseException {
    NumberFormat format = getNumberFormat(locale);
    return (BigDecimal) format.parse(text);
  }
  
  protected NumberFormat getNumberFormat(Locale locale) {
    DecimalFormat format = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
    format.setParseBigDecimal(true);
    format.setMaximumFractionDigits(2);
    format.setMinimumFractionDigits(2);
    format.setCurrency(Currency.getInstance("USD"));
    return format;
  }

}
