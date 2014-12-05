/*
Copyright 2014 Zoi Capital, LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.zoicapital.stockchartsfx;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 *
 * @author RobTerpilowski
 */
public class BarData implements Serializable {
        
    public static long serialVersionUID = 1L;

    public static final double NULL = -9D;
    public static final int OPEN = 1;
    public static final int HIGH = 2;
    public static final int LOW = 3;
    public static final int CLOSE = 4;

    public enum LENGTH_UNIT {

        TICK, SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, YEAR
    };

    protected double open;
    protected BigDecimal formattedOpen;
    protected double high;
    protected BigDecimal formattedHigh;
    protected double low;
    protected BigDecimal formattedLow;
    protected double close;
    protected BigDecimal formattedClose;
    protected long volume = 0;
    protected long openInterest = 0;
    protected int barLength = 1;
    protected GregorianCalendar dateTime;
    //protected Logger logger = Logger.getLogger( Bar.class );

    public BarData() {
    }

    public BarData( GregorianCalendar dateTime, double open, double high, double low, double close, long volume) {
        this.dateTime = dateTime;
        this.open = open;
        this.formattedOpen = format(open);
        this.close = close;
        this.formattedClose = format(close);
        this.low = low;
        this.formattedLow = format(low);
        this.high = high;
        this.formattedHigh = format(high);
        this.volume = volume;
    }

    
    /**
     * Creates a new instance of a Bar
     *
     * @param date The date of this bar.
     * @param open The open price.
     * @param high The high price.
     * @param low The low price.
     * @param close The closing price.
     * @param volume The volume for the bar.
     * @param openInterest The open interest for the bar.
     */
    public BarData(GregorianCalendar dateTime, double open, double high, double low, double close, long volume, long openInterest) {
        this(dateTime, open, high, low, close, volume);
        this.openInterest = openInterest;
    }//constructor()

    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the open price of this bar.
     */
    public double getOpen() {
        return open;
    }

    /**
     * @return the High price of this bar.
     */
    public double getHigh() {
        return high;
    }

    /*
     * @return the Low price of this Bar.
     */
    public double getLow() {
        return low;
    }

    /**
     * @return the close price for this bar.
     */
    public double getClose() {
        return close;
    }

    /**
     * @return the Volume for this bar.
     */
    public long getVolume() {
        return volume;
    }

    /**
     * @return the open interest for this bar.
     */
    public long getOpenInterest() {
        return openInterest;
    }

    /**
     * Sets the open price for this bar.
     *
     * @param open The open price for this bar.
     */
    public void setOpen(double open) {
        this.open = open;
    }

    /**
     * Sets the high price for this bar.
     *
     * @param high The high price for this bar.
     */
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * Sets the low price for this bar.
     *
     * @param low The low price for this bar.
     */
    public void setLow(double low) {
        this.low = low;
    }

    /**
     * Sets the closing price for this bar.
     *
     * @param close The closing price for this bar.
     */
    public void setClose(double close) {
        this.close = close;
    }

    /**
     * Sets the volume for this bar.
     *
     * @param volume Sets the volume for this bar.
     */
    public void setVolume(long volume) {
        this.volume = volume;
    }
    
    
    /**
     * Updates the last price, adjusting the high and low
     * @param close The last price
     */
    public void update( double close ) {
        if( close > high ) {
            high = close;
        }
        
        if( close < low ) {
            low = close;
        }
        this.close = close;
    }
    

    /**
     * Sets the open interest for this bar.
     *
     * @param openInterest The open interest for this bar.
     */
    public void setOpenInterest(long openInterest) {
        this.openInterest = openInterest;
    }
    
    protected BigDecimal format( double price ) {
        return BigDecimal.ZERO;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(dateTime.getTime());
        sb.append(" Open: ").append(open);
        sb.append(" High: ").append(high);
        sb.append(" Low: ").append(low);
        sb.append(" Close: ").append(close);
        sb.append(" Volume: ").append(volume);
        sb.append(" Open Int ").append(openInterest);

        return sb.toString();
    }//toString()

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(close);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(open);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(openInterest);
        result = PRIME * result + (int) (temp ^ (temp >>> 32));
        result = PRIME * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = PRIME * result + (int) (volume ^ (volume >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BarData other = (BarData) obj;
        if (Double.doubleToLongBits(close) != Double.doubleToLongBits(other.close)) {
            return false;
        }
        if (Double.doubleToLongBits(high) != Double.doubleToLongBits(other.high)) {
            return false;
        }
        if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low)) {
            return false;
        }
        if (Double.doubleToLongBits(open) != Double.doubleToLongBits(other.open)) {
            return false;
        }
        if (Double.doubleToLongBits(openInterest) != Double.doubleToLongBits(other.openInterest)) {
            return false;
        }
        if (dateTime == null) {
            if (other.dateTime != null) {
                return false;
            }
        } else if (!dateTime.equals(other.dateTime)) {
            return false;
        }
        if (volume != other.volume) {
            return false;
        }
        return true;
    }
    
}
