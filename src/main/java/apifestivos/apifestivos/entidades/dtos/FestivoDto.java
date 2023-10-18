package apifestivos.apifestivos.entidades.dtos;

import java.util.Date;

public class FestivoDto {

    private String festivo;
    private Date fecha;

    public FestivoDto() {
    }

    public FestivoDto(String festivo, Date fecha) {
        this.festivo = festivo;
        this.fecha = fecha;
    }

    public String getFestivo() {
        return festivo;
    }

    public void setFestivo(String festivo) {
        this.festivo = festivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
