package persona;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MiCalendar extends GregorianCalendar {

    public MiCalendar(int día, int mes, int año) throws FechaInvalidaException {
        super(año, mes - 1, día);

        //Para evitar errores del estilo 941/2/2013 aka 941 dias despues del primero de febrero
        setLenient(false);

        try {
            get(DAY_OF_MONTH);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El día es inválido.");
        }

        try {
            get(MONTH);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El mes es inválido.");
        }

        try {
            get(YEAR);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El año es inválido.");
        }
    }

    public MiCalendar(Calendar calendar) throws FechaInvalidaException {
        setDía(calendar.get(DAY_OF_MONTH));
        setMes(calendar.get(MONTH) + 1);
        setAño(calendar.get(YEAR));
    }

    public MiCalendar(Date date) {
        setTimeInMillis(date.getTime());
    }

    void setDía(int día) throws FechaInvalidaException {
        set(DAY_OF_MONTH, día);

        try {
            get(DAY_OF_MONTH);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El día es inválido.");
        }
    }

    int getDía() {
        return get(DAY_OF_MONTH);
    }

    void setMes(int mes) throws FechaInvalidaException {
        set(MONTH, mes - 1);

        try {
            get(MONTH);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El mes es inválido.");
        }
    }

    int getMes() {
        return get(MONTH) + 1;
    }

    void setAño(int año) throws FechaInvalidaException {
        set(YEAR, año);

        try {
            get(YEAR);
        } catch (IllegalArgumentException ex) {
            throw new FechaInvalidaException("El año es inválido.");
        }
    }

    int getAño() {
        return get(YEAR);
    }

    @Override
    public String toString() {
        return String.format("%02d", getDía()) + "/" + String.format("%02d", getMes()) + "/" + getAño();
    }

    public Date toDate() {
        return new Date(getTimeInMillis());
    }
}
